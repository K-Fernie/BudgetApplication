package com.budgetapplication.model;

import javafx.collections.ObservableList;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.LocalDate;

public class TransactionsTest {

    @Test
    void readTransactions_validateRead() throws IOException {
        Transactions.readTransactions();
    }

    @Test
    void writeTransactions_validateRead() throws IOException {
        ObservableList<Transaction> transaction;
        Transactions.readTransactions();
        transaction = Transactions.getTransactions();
        System.out.println(transaction);
        transaction.add(new Transaction(LocalDate.of(2022, 1, 14), "bought chips", BucketType.GROCERIES, Transaction.Category.EXPENDITURE, 5.55, 123));
        transaction.add(new Transaction(LocalDate.of(2022, 1, 20), "bought chips", BucketType.GROCERIES, Transaction.Category.EXPENDITURE, 5.55, 123));
        transaction.add(new Transaction(LocalDate.of(2022, 1, 22), "bought chips", BucketType.GROCERIES, Transaction.Category.EXPENDITURE, 5.55, 123));
        System.out.println("-------------------------------------------------");
        System.out.println(Transactions.getTransactions());
        Transactions.writeTransactions();
    }
}