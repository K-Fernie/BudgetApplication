package com.budgetapplication.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsTest {

    @Test
    void readTransactions_validateRead() throws IOException {
        Transactions.readTransactions();
        assertEquals(LocalDate.of(2022, 6, 28), Transactions.getTransactions().get(0).getDate());
        assertEquals("Amazon Paycheck", Transactions.getTransactions().get(0).getDescription());
        assertEquals(BucketType.PAYCHECK, Transactions.getTransactions().get(0).getCategory());
        assertEquals(Transaction.Category.INCOME, Transactions.getTransactions().get(0).getType());
        assertEquals(1500.00, Transactions.getTransactions().get(0).getAmount());
        assertEquals(123, Transactions.getTransactions().get(0).getBankId());
    }

    @Test
    void readTransactions_invalidRead() throws IOException {
        Transactions.readTransactions();
        try {
            Transactions.getTransactions().get(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There should be no other users");
        }
    }

    @Test
    void writeTransactions_valid() throws IOException {
        ObservableList<Transaction> transaction;
        Transactions.readTransactions();
        transaction = Transactions.getTransactions();
        transaction.add(new Transaction(LocalDate.of(2022, 1, 14), "bought chips", BucketType.GROCERIES, Transaction.Category.EXPENDITURE, 5.55, 123));
        Transactions.writeTransactions();
        assertEquals(LocalDate.of(2022, 1, 14), Transactions.getTransactions().get(Transactions.getTransactions().size() - 1).getDate());
        assertEquals("bought chips", Transactions.getTransactions().get(Transactions.getTransactions().size() - 1).getDescription());
        assertEquals(BucketType.GROCERIES, Transactions.getTransactions().get(Transactions.getTransactions().size() - 1).getCategory());
        assertEquals(Transaction.Category.EXPENDITURE, Transactions.getTransactions().get(Transactions.getTransactions().size() - 1).getType());
        assertEquals(5.55, Transactions.getTransactions().get(Transactions.getTransactions().size() - 1).getAmount());
        assertEquals(123, Transactions.getTransactions().get(Transactions.getTransactions().size() - 1).getBankId());
    }
}