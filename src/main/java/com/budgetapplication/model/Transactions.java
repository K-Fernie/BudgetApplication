package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;

/**
 * Transactions is a utility class that's used to read and write into the
 * associated csv files. It contains a static observable list that holds
 * all the transactions for the active user. The list is passed to the
 * Bank Account class to be used for the user interface.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class Transactions {
    private static ObservableList<Transaction> transaction;
    private static int transactionSize = 0;

    /**
     * This method is used to read the transaction-info.csv file from the resource
     * folder. It uses Buffer Reader with an Input file stream. The file data are
     * separated by a comma delimiter. The input stream is stored into a
     * static Observable list of transaction that will be used in Bank Account.
     * @throws IOException
     */
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

    /**
     * This method is used to write the changes in transactions that came
     * from the user interface. Users can delete transactions and add new
     * transactions. On logout, the transactions will be updated.
     * @throws IOException
     */
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

    /**
     * This method is used to pass the static observable list to a BankAccount class
     * reference.
     * @return transaction - a list of transactions
     */
    public static synchronized ObservableList<Transaction> getTransactions() {
        return transaction;
    }
}
