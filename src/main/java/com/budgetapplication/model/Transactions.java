package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;

public class Transactions {
    private static ObservableList<Transaction> transaction;
    private static int transactionSize = 0;

    public static synchronized void readTransactions() throws IOException {
        if (null == transaction) {
            transaction = FXCollections.observableArrayList();
            String file = "src/main/resources/com.budgetapplication.file/transaction-info.csv";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");
                transaction.add(new Transaction(LocalDate.parse(tokens[0]), tokens[1],
                        Enum.valueOf(BucketType.class, tokens[2]), Enum.valueOf(Transaction.Category.class, tokens[3]),
                        Double.parseDouble(tokens[4]), Integer.parseInt(tokens[5])));
            }
            transactionSize = transaction.size();
        }
    }

    public static synchronized void writeTransactions() throws IOException {
        String file = "src/main/resources/com.budgetapplication.file/transaction-info.csv";
        Writer output;
        try {
            output = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < transaction.size(); i++) {
                output.append(transaction.get(i).toString());
            }
            output.close();
        } catch (IOException e) {
        }

    }

    public static synchronized void addTransactions(Transaction newTransaction) {
        transaction.add(newTransaction);
    }

    public static synchronized ObservableList<Transaction> getTransactions() {
        return transaction;
    }
}
