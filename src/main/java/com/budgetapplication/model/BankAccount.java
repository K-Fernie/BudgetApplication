package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BankAccount {

    private int accountId;
    private double accountTotal;
    private static ObservableList<Bucket> allBuckets = FXCollections.observableArrayList();
    private static ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();

    public BankAccount(int accountId, double accountTotal) {
        this.accountId = accountId;
        this.accountTotal = accountTotal;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(double accountTotal) {
        this.accountTotal = accountTotal;
    }

    public static ObservableList<Bucket> getAllBuckets() {
        return allBuckets;
    }

    public void setAllBuckets(ObservableList<Bucket> allBuckets) {
        BankAccount.allBuckets = allBuckets;
    }

    public static ObservableList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(ObservableList<Transaction> allTransactions) {
        BankAccount.allTransactions = allTransactions;
    }

    public static void addTransaction(Transaction transaction){
        allTransactions.add(transaction);
    }
}
