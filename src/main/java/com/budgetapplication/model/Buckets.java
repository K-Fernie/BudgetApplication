package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

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
        // TODO write to the transactions file and save new content
        String File = "TRANSACTIONS.csv";
        Writer output;
        try {
            output = new BufferedWriter(new FileWriter(File));
            for (int i = 0; i < allocateBucket.size(); i++) {
                output.write(allocateBucket.get(i).toString());
            }
            output.close();
        } catch (IOException e) {
        }
    }

    public static synchronized ObservableList<Bucket> getBuckets(){
        return allocateBucket;
    }
}
