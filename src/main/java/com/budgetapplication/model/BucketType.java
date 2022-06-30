package com.budgetapplication.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * BucketType is an Enum class used for all the allocation types available for budgeting.
 * This types will have a total dollar value and a value shared between 100% allocation.
 * This Enum is used in the Bucket class with a "Has-a" relationship.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public enum BucketType {
    HOUSING, TRANSPORTATION, GROCERIES, UTILITIES, SUBSCRIPTIONS, INVESTMENTS, MEDICAL, INTERNET, PERSONAL, PAYCHECK, GIFT;

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
