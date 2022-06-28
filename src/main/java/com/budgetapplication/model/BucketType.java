package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public enum BucketType {
    HOUSING, TRANSPORTATION, GROCERIES, UTILITIES, SUBSCRIPTIONS, INVESTMENTS, MEDICAL, INTERNET, PERSONAL, PAYCHECK, GIFT;

    //TODO override the toString method to show the enum not in all caps
    private static final ObservableList<BucketType> bucketTypes = FXCollections.observableArrayList(BucketType.values());

    public static ObservableList<BucketType> getBucketTypes() {
        return bucketTypes;
    }

    @Override
    public String toString() {
        String copy = super.toString();
        return copy.substring(0, 1).toUpperCase() + copy.substring(1).toLowerCase();
    }
}
