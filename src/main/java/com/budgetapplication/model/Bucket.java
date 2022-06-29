package com.budgetapplication.model;

/**
 * Bucket is a storage class that holds information about the type of bucket, its allocation
 * total, and its percentage value compared to all other bucket types.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class Bucket {
    private BucketType bucketType;
    private double percentage;
    private double bucketTotal;

    /**
     * This constructor is used to set the bucket fields. It is the only constructor and it
     * has 3 parameters.
     *
     * @param bucket - the bucket type that will be used to set its allocation values
     * @param percentage - the percentage of allocation for the bucket type
     * @param bucketTotal - the total dollar value of the bucket for its percentage type
     */
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
        return bucketType + "," + percentage + "," + bucketTotal + "\n";
    }
}
