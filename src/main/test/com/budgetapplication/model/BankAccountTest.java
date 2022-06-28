package com.budgetapplication.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void updateBucketAllocationsTest() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        Bucket testBucket = new Bucket(BucketType.HOUSING, 0.30, 300.00);
    }
}