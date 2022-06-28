package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Transactions {
    private static ObservableList<Transaction> transaction;
    private static int transactionSize = 0;

    public static synchronized void readTransactions(int bankId) {
        if (null == transaction) {
            transaction = FXCollections.observableArrayList();
            String File = "TRANSACTIONS.csv";
            Scanner scan = new Scanner(Objects.requireNonNull(Transactions.class.getResourceAsStream(File)));
            String line;
            while ((line = scan.nextLine()) != null) {
                String[] tokens = line.split(",");
                // Add condition that allows only user with bankId info
                if (bankId == Integer.parseInt(tokens[5])) {
                    transaction.add(new Transaction(LocalDate.parse(tokens[0]), tokens[1],
                            Enum.valueOf(BucketType.class, tokens[2]), Enum.valueOf(Transaction.Category.class, tokens[3]),
                            Double.parseDouble(tokens[4]), Integer.parseInt(tokens[5])));
                }
            }
            scan.close();
            transactionSize = transaction.size();
        }
    }

    public static synchronized void writeTransactions() throws IOException {
        if(transactionSize < transaction.size()){
            // TODO write to the transactions file and save new content
            String File = "TRANSACTIONS.csv";
            Writer output;
            try {
                output = new BufferedWriter(new FileWriter(File));
                for(int i = transactionSize; i < transaction.size(); i++){
                    output.append(transaction.get(i).toString());
                }
                output.close();
            } catch (IOException e) {
            }

        }
    }

    public static synchronized void addTransactions(Transaction newTransaction){
        transaction.add(newTransaction);
    }

    public static synchronized ObservableList<Transaction> getTransactions(){
        return transaction;
    }
}
