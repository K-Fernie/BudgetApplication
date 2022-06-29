package com.budgetapplication.model;

import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private String description;
    private Enum<BucketType> category;
    private Enum<Category> type;
    private double amount;
    private int bankId;
    private static ObservableList<Transaction> transactions;

    public enum Category {

        INCOME, EXPENDITURE

    }


    public Transaction(LocalDate date, String description, BucketType bucketType, Category category, double amount, int bankId) {
        setDate(date);
        setDescription(description);
        setCategory(bucketType);
        setType(category);
        setAmount(amount);
        setBankId(bankId);
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

    public Enum<Category> getType() {
        return type;
    }

    public void setType(Enum<Category> type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public ObservableList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ObservableList<Transaction> transactions) {
        Transaction.transactions = transactions;
    }

    @Override
    public String toString() {
        return date + "," + description + "," + category + "," + type + "," + amount + "," + bankId + "\n";
    }
}
