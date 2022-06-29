package com.budgetapplication.model;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.io.IOException;
import java.time.LocalDate;

public class BankAccountTest {

    @Test
    void findPercentageValue_readVerification() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        assertEquals(0.1, BankAccount.findPercentageValue(BucketType.HOUSING), 0.001);
        assertEquals(0.1, BankAccount.findPercentageValue(BucketType.TRANSPORTATION), 0.001);
        assertEquals(0.1, BankAccount.findPercentageValue(BucketType.GROCERIES), 0.001);
    }

    @Test
    void findBucketValue_readVerification() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        assertEquals(150, BankAccount.findBucketValue(BucketType.HOUSING));
        assertEquals(150, BankAccount.findBucketValue(BucketType.TRANSPORTATION));
        assertEquals(150, BankAccount.findBucketValue(BucketType.GROCERIES));
    }

    @Test
    void addTransactionUpdateBuckets_incomeTransaction() throws IOException {
        Transactions.readTransactions();
        Buckets.readBuckets();
        BankAccount.setAllTransactions(Transactions.getTransactions());
        BankAccount.setAllBuckets(Buckets.getBuckets());
        BankAccount.addTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.PAYCHECK, Transaction.Category.INCOME,
                1500.00, 123));
        assertEquals(3000.00, BankAccount.getAccountTotal());
        BankAccount.addTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.PAYCHECK, Transaction.Category.INCOME,
                1500.00, 123));
        assertEquals(4500.00, BankAccount.getAccountTotal());
    }

    @Test
    void addTransactionUpdateBuckets_expenseTransaction() throws IOException {
        Transactions.readTransactions();
        Buckets.readBuckets();
        BankAccount.setAllTransactions(Transactions.getTransactions());
        BankAccount.setAllBuckets(Buckets.getBuckets());
        BankAccount.addTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.GROCERIES, Transaction.Category.EXPENDITURE,
                150.00, 123));
        assertEquals(1350.00, BankAccount.getAccountTotal());
        BankAccount.addTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.HOUSING, Transaction.Category.EXPENDITURE,
                1000.00, 123));
        assertEquals(350.00, BankAccount.getAccountTotal());
    }

    @Test
    void removeTransactionUpdateBuckets_incomeTransaction() throws IOException {
        Transactions.readTransactions();
        Buckets.readBuckets();
        BankAccount.setAllTransactions(Transactions.getTransactions());
        BankAccount.setAllBuckets(Buckets.getBuckets());
        BankAccount.removeTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.PAYCHECK, Transaction.Category.INCOME,
                150.00, 123));
        assertEquals(1350.00, BankAccount.getAccountTotal());
        BankAccount.removeTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.PAYCHECK, Transaction.Category.INCOME,
                500.00, 123));
        assertEquals(850.00, BankAccount.getAccountTotal());

    }

    @Test
    void removeTransactionUpdateBuckets_expenseTransaction() throws IOException {
        Transactions.readTransactions();
        Buckets.readBuckets();
        BankAccount.setAllTransactions(Transactions.getTransactions());
        BankAccount.setAllBuckets(Buckets.getBuckets());
        BankAccount.removeTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.GROCERIES, Transaction.Category.EXPENDITURE,
                150.00, 123));
        assertEquals(1650.00, BankAccount.getAccountTotal());
        BankAccount.removeTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.HOUSING, Transaction.Category.EXPENDITURE,
                500.00, 123));
        assertEquals(2150.00, BankAccount.getAccountTotal());
    }

    @Test
    void updateBucketAllocations_nonNegative() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        Bucket testBucket = new Bucket(BucketType.HOUSING, 0.30, 300.00);
    }

    @Test
    void isAllocated_allocationFalse() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        assertEquals(false, BankAccount.isAllocated());
    }

    @Test
    void isAllocated_allocationTrue() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        assertEquals(true, BankAccount.isAllocated());
    }

    @Test
    void setAccountTotal_validate() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        BankAccount.setAccountTotal();
        assertEquals(1500, BankAccount.getAccountTotal());
    }

}