package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

/**
 * Buckets is a utility class that's used to read and write into the
 * associated csv files. It contains a static observable list that holds
 * all the bucket types and their allocations for the active user. The
 * list is passed to the Bank Account class to be used for the user
 * interface.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class Buckets {
    private static ObservableList<Bucket> allocateBucket;

    public static synchronized void readBuckets() throws IOException {
        if (null == allocateBucket) {
            allocateBucket = FXCollections.observableArrayList();
            String file = "src/main/resources/com.budgetapplication.file/bucket-info.csv";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");
                allocateBucket.add(new Bucket(Enum.valueOf(BucketType.class, tokens[0]), Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
            }
        }
    }

    public static synchronized void writeTransactions() throws IOException {
        String file = "src/main/resources/com.budgetapplication.file/bucket-info.csv";
        Writer output;
        try {
            output = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < allocateBucket.size(); i++) {
                output.write(allocateBucket.get(i).toString().toUpperCase());
            }
            output.close();
        } catch (IOException e) {
        }
    }

    public static synchronized ObservableList<Bucket> getBuckets(){
        return allocateBucket;
    }
}
