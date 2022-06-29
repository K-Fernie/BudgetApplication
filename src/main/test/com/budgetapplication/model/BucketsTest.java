package com.budgetapplication.model;

import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.*;

public class BucketsTest {

    @Test
    void readBuckets_validation() throws IOException {
        assertNull(Buckets.getBuckets());
        Buckets.readBuckets();
        assertNotNull(Buckets.getBuckets());
        BankAccount.setAllBuckets(Buckets.getBuckets());

        assertEquals(0.30, Buckets.getBuckets().get(1));

    }

    @Test
    void writeBuckets_validation(){

    }
}