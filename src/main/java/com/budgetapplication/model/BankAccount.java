package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * BankAccount is a utility class used to store information about all the user transactions
 * and bucket allocations. It contains observable lists that are utilized with the user
 * interface for presenting information. Represents a bank account for a user.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class BankAccount {

    private static int accountId;
    private static double accountTotal;
    private static ObservableList<Bucket> allBuckets = FXCollections.observableArrayList();
    private static ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();

    /**
     * This method finds the type of bucket and returns its associated allocation percentage.
     * @param type - the bucket type that has a percentage value to its allocation amount.
     * @return bucketPercent - the percent allocation amount for that bucket
     */
    public static double findPercentageValue(BucketType type){
        double bucketPercent = 0.00;
        for(Bucket bucket: BankAccount.getAllBuckets()){
            if(bucket.getBucketType().equals(type)){
                bucketPercent = bucket.getPercentage();
            }
        }
        return bucketPercent;
    }

    /**
     * This method finds the type of bucket and returns its associated total dollar value.
     * @param type - the bucket type that has a total dollar value
     * @return bucketTotal - the total dollar value associated with that bucket type
     */
    public static double findBucketValue(BucketType type){
        double bucketTotal = 0.00;
        for(Bucket bucket: BankAccount.getAllBuckets()){
            if(bucket.getBucketType().equals(type)){
                bucketTotal = bucket.getBucketTotal();
            }
        }
        return bucketTotal;
    }

    /**
     * This method determines if the new transaction is income or an expense, and updates the corresponding bucket type
     * with a new total value. The new bucket total value is then updated into the account total value.
     * @param transaction - income or expense transaction that is used to update the accountTotal value
     */
    public static void addTransactionUpdateBuckets(Transaction transaction){
        double transactionAmt = transaction.getAmount();
        accountTotal = 0.00;
        for(Bucket bucket: allBuckets) {
            if (transaction.getType().equals(Transaction.Category.INCOME)) {
                double bucketTotal = bucket.getBucketTotal() + (transactionAmt * bucket.getPercentage());
                bucket.setBucketTotal(bucketTotal);
            }
            else{
                if(bucket.getBucketType().equals(transaction.getCategory())){
                    double bucketTotal = bucket.getBucketTotal() - transactionAmt;
                    bucket.setBucketTotal(bucketTotal);
                }
            }
            accountTotal += bucket.getBucketTotal();
        }
    }

    /**
     * This method determines if the removed transaction is an income or expense, and subtracts it from the corresponding bucket
     * with a new total value. The new bucket value is then updated into the account total value.
     * @param transaction - selected transaction from the table that is used to update the account total value.
     */
    public static void removeTransactionUpdateBuckets(Transaction transaction){
        double transactionAmt = transaction.getAmount();
        accountTotal = 0.00;
        for(Bucket bucket: allBuckets) {
            if (transaction.getType().equals(Transaction.Category.INCOME)) {
                double bucketTotal = bucket.getBucketTotal() - (transactionAmt * bucket.getPercentage());
                bucket.setBucketTotal(bucketTotal);
            }
            else{
                if(bucket.getBucketType().equals(transaction.getCategory())){
                    double bucketTotal = bucket.getBucketTotal() + transactionAmt;
                    bucket.setBucketTotal(bucketTotal);
                }
            }
            accountTotal += bucket.getBucketTotal();
        }
    }

    /**
     * This method is used to update the bucket type allocation percentage.
     * @param type - the bucket type that will have its allocation percentage updated.
     * @param percent - the percentage amount used to update the bucket
     */
    public static void updateBucketAllocations(BucketType type, double percent) {
        for (Bucket bucket : allBuckets) {
            if (bucket.getBucketType().equals(type)) {
                bucket.setPercentage(percent);
            }
        }
    }

    /**
     * This method is used to help determine if the total allocation of all buckets is 100%
     * @return isAllocated - buckets is or isn't 100% allocated
     */
    public static boolean isAllocated(){
        boolean isAllocated = false;
        double percentageSum = 0.00;
        for(Bucket bucket: allBuckets){
            percentageSum += bucket.getPercentage();
        }
        isAllocated = percentageSum == 1.00;
        return isAllocated;
    }

    /**
     * This method gets the account ID of the current user.
     * @return accountID - the account ID associated with a user.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * This method is used to set the account ID
     * @param accountId - account ID associated with the user
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * This method gets the account total
     * @return accountTotal - the account total for all buckets
     */
    public static double getAccountTotal() {
        return accountTotal;
    }

    /**
     * This method sets the account total for all associated buckets
     */
    public static void setAccountTotal() {
        accountTotal = 0;
        for(Bucket bucket: allBuckets){
            accountTotal += bucket.getBucketTotal();
        }
    }

    /**
     * This method gets all the associated buckets in the observable list
     * @return allBuckets - a list of all buckets
     */
    public static ObservableList<Bucket> getAllBuckets() {
        return allBuckets;
    }

    /**
     * This method sets all buckets to the bank account observable list for all buckets.
     * @param allBuckets - a list of all buckets
     */
    public static void setAllBuckets(ObservableList<Bucket> allBuckets) {
        BankAccount.allBuckets = allBuckets;
    }

    /**
     * This method gets all the transactions for the observable list.
     * @return allTransactions - a list of all transactions for the active user
     */
    public static ObservableList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    /**
     * This method sets all the transactions to the bank account observable list.
     * @param allTransactions
     */
    public static void setAllTransactions(ObservableList<Transaction> allTransactions) {
        BankAccount.allTransactions = allTransactions;
    }

    /**
     * This method will add a new transaction to the list of transactions associated with a user.
     * @param transaction
     */
    public static void addTransaction(Transaction transaction){
        allTransactions.add(transaction);
    }

}
