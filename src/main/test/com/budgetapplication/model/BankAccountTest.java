package com.budgetapplication.model;

import org.testng.annotations.Test;

import java.io.IOException;

class BankAccountTest {
    @Test
    void updateBucketAllocationsTest() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        Bucket testBucket = new Bucket(BucketType.HOUSING, 0.30, 300.00);

    }
}