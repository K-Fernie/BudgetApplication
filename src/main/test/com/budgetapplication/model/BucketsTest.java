package com.budgetapplication.model;

import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.*;

public class BucketsTest {

    @Test(expectedExceptions = NumberFormatException.class)
    void readBuckets_numberFormatExceptionTest() throws IOException {
        Buckets.readBuckets();
    }

    @Test(expectedExceptions = IOException.class)
    void readBuckets_ioExceptionTest() throws IOException {
        Buckets.readBuckets();
    }

    @Test
    void readBuckets_valid() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        BankAccount.setAccountTotal();
        assertEquals(1500, BankAccount.getAccountTotal());

    }

    @Test
    void readBuckets_invalid() throws IOException {
        Buckets.readBuckets();
        BankAccount.setAllBuckets(Buckets.getBuckets());
        assertNotEquals(1500, BankAccount.getAccountTotal());
    }
}