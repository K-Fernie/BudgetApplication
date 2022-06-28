package com.budgetapplication.model;

public class Bucket {
    private BucketType bucketType;
    private double percentage;
    private double bucketTotal;

    public Bucket(BucketType bucket, double percentage, double bucketTotal){
        setBucketType(bucket);
        setPercentage(percentage);
        setBucketTotal(bucketTotal);
    }


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

    @Override
    public String toString() {
        // BucketType bucket, double percentage, double bucketTotal
        return bucketType + ", " + percentage + ", " + bucketTotal;
    }
}
