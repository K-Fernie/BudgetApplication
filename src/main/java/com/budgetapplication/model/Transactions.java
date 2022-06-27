package com.budgetapplication.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transactions {
    private static List<Transaction> transaction;

    public static synchronized void readTransactions() {
        if (null == transaction) {
            transaction = new ArrayList<Transaction>();
            String File = ("TRANSACTIONS.csv");
            Scanner scan = new Scanner(Transactions.class.getResourceAsStream(File));
            String line;
            while ((line = scan.nextLine()) != null) {
                String[] tokens = line.split(",");
                // TODO: Add condition that allows only user with bankId info
                transaction.add(new Transaction(LocalDate.parse(tokens[0]), tokens[1],
                        Enum.valueOf(BucketType.class, tokens[2]), Enum.valueOf(Transaction.TransactionCategory.class, tokens[3]),
                        Double.parseDouble(tokens[4])));
            }
            scan.close();
        }
    }
}
