package com.budgetapplication.model;

import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private String description;
    private Enum<BucketType> category;
    private Enum<TransactionCategory> type;
    private double amount;
    private static ObservableList<Transaction> transactions;

    public Transaction(LocalDate date, String description, Enum<BucketType> category, Enum<TransactionCategory> type, double amount) {
        setDate(date);
        setDescription(description);
        setCategory(category);
        setType(type);
        setAmount(amount);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum<BucketType> getCategory() {
        return category;
    }

    public void setCategory(Enum<BucketType> category) {
        this.category = category;
    }

    public Enum<TransactionCategory> getType() {
        return type;
    }

    public void setType(Enum<TransactionCategory> type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ObservableList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ObservableList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
