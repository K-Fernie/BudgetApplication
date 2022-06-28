package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class BankAccount {

    private static int accountId;
    private static double accountTotal;
    private static ObservableList<Bucket> allBuckets = FXCollections.observableArrayList();
    private static ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();


    public static double findPercentageValue(BucketType type){
        double bucketPercent = 0.00;
        for(Bucket bucket: BankAccount.getAllBuckets()){
            if(bucket.getBucketType().equals(type)){
                bucketPercent = bucket.getPercentage();
            }
        }
        return bucketPercent;
    }

    public static double findLabelValue(BucketType type){
        double bucketTotal = 0.00;
        for(Bucket bucket: BankAccount.getAllBuckets()){
            if(bucket.getBucketType().equals(type)){
                bucketTotal = bucket.getBucketTotal();
            }
        }
        return bucketTotal;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public static double getAccountTotal() {
        return accountTotal;
    }

    public static void setAccountTotal() {
        for(Bucket bucket: allBuckets){
            accountTotal += bucket.getBucketTotal();
        }
    }

    public static ObservableList<Bucket> getAllBuckets() {
        return allBuckets;
    }

    public static void setAllBuckets(ObservableList<Bucket> allBuckets) {
        BankAccount.allBuckets = allBuckets;
    }

    public static ObservableList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public static void setAllTransactions(ObservableList<Transaction> allTransactions) {
        BankAccount.allTransactions = allTransactions;
    }

    public static void addTransaction(Transaction transaction){
        //TODO call a method to update buckets when a transaction is added to the list
        //TODO call a method to update the account total when a transaction is added to the list
        allTransactions.add(transaction);
    }
}
