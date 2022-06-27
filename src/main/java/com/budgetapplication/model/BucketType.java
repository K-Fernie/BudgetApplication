package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public enum BucketType {
    HOUSING, TRANSPORTATION, GROCERIES, UTILITIES, SUBSCRIPTIONS, INVESTMENTS, MEDICAL, INTERNET, PERSONAL, PAYCHECK, GIFT;

    //creating an observable list of bucket types to be displayed in a combobox/choice box
    private static final ObservableList<BucketType> bucketTypes = FXCollections.observableArrayList(BucketType.values());

    public static ObservableList<BucketType> getBucketTypes() {
        return bucketTypes;
    }
}
