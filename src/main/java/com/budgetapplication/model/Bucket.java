package com.budgetapplication.model;

public class Bucket {
    private BucketType bucketType;
    private double percentage;
    private double bucketTotal;

    public BucketType getBucketType() {
        return bucketType;
    }

    public void setBucketType(BucketType bucketType) {
        this.bucketType = bucketType;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getBucketTotal() {
        return bucketTotal;
    }

    public void setBucketTotal(double bucketTotal) {
        this.bucketTotal = bucketTotal;
    }
}
