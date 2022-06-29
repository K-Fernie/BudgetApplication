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
        BankAccount.setAllTransactions(Transactions.getTransactions());
        BankAccount.addTransactionUpdateBuckets(new Transaction(
                LocalDate.parse("2022-06-28"), "Amazon Paycheck",
                BucketType.PAYCHECK, Transaction.Category.INCOME, 1500.00, 123));
    }

    @Test
    void addTransactionUpdateBuckets_expenseTransaction(){

    }

    @Test
    void removeTransactionUpdateBuckets_incomeTransaction(){

    }

    @Test
    void removeTransactionUpdateBuckets_expenseTransaction(){

    }

    @Test
    void updateBucketAllocations_nonNegative() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        Bucket testBucket = new Bucket(BucketType.HOUSING, 0.30, 300.00);
    }

    @Test
    void isAllocated_allocationFalse(){

    }

    @Test
    void isAllocated_allocationTrue(){

    }

    @Test
    void setAccountTotal_validate(){

    }

}