package com.budgetapplication.model;

import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Transaction is a storage class used to hold the information about the
 * users income and expense transactions. This class is used for getting
 * and setting field values that will be used mostly by the Bank Account
 * class.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
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

    /**
     * This constructor is the only constructor and it consists of 6 parameters. This
     * constructor can be called when deleting/adding a new transaction in the user
     * interface. It will also be called by the Transactions utility class when reading
     * the associated csv file.
     * @param date - the date of the transaction
     * @param description - the description of the transaction
     * @param bucketType - the type of budgeting bucket the transaction is associated with
     * @param category - the type of transaction, income or expense
     * @param amount - the dollar amount of the transaction
     * @param bankId - the bank ID of the user associated with this transaction
     */
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
