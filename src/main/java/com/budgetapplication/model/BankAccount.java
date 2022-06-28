package com.budgetapplication.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public static void updateBuckets(Transaction transaction){
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

    public static void updateBucketAllocations(BucketType type, double percent) {
        for (Bucket bucket : allBuckets) {
            if (bucket.getBucketType().equals(type)) {
                bucket.setPercentage(percent);
            }
        }
    }

    public static boolean isAllocated(){
        boolean isAllocated = false;
        double percentageSum = 0.00;
        for(Bucket bucket: allBuckets){
            percentageSum += bucket.getPercentage();
        }
        isAllocated = percentageSum == 1.00;
        return isAllocated;
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
        accountTotal = 0;
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
        allTransactions.add(transaction);
    }

}
