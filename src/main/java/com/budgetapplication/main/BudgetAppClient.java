package com.budgetapplication.main;

import com.budgetapplication.model.BankAccount;
import com.budgetapplication.model.Bucket;
import com.budgetapplication.model.BucketType;
import com.budgetapplication.model.Transaction;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class BudgetAppClient extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BudgetAppClient.class.getResource("budget-overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Budget App Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ObservableList<Bucket> buckets = FXCollections.observableArrayList();
        buckets.add(new Bucket(BucketType.HOUSING, .3,300.00));
        buckets.add(new Bucket(BucketType.TRANSPORTATION, .1, 100.));
        buckets.add(new Bucket(BucketType.GROCERIES, .10,100));
        buckets.add(new Bucket(BucketType.UTILITIES, .08,80));
        buckets.add(new Bucket(BucketType.SUBSCRIPTIONS, .08, 80));
        buckets.add(new Bucket(BucketType.INVESTMENTS, .1, 100));
        buckets.add(new Bucket(BucketType.MEDICAL, .05, 50.00));
        buckets.add(new Bucket(BucketType.INTERNET, .07, 70.00));
        buckets.add(new Bucket(BucketType.PERSONAL, .12, 120));
        BankAccount.setAllBuckets(buckets);

        ObservableList<Transaction> transactions = FXCollections.observableArrayList();
        transactions.add(new Transaction(LocalDate.now(),"bought chips",BucketType.GROCERIES,Transaction.Category.EXPENDITURE,50,123));
        transactions.add(new Transaction(LocalDate.now(),"car",BucketType.TRANSPORTATION,Transaction.Category.EXPENDITURE,15,123));
        transactions.add(new Transaction(LocalDate.now(),"paycheck amazon",BucketType.PAYCHECK,Transaction.Category.INCOME,1000,123));
        transactions.add(new Transaction(LocalDate.now(),"bought chips",BucketType.GROCERIES,Transaction.Category.EXPENDITURE,25,123));
        transactions.add(new Transaction(LocalDate.now(),"clothess",BucketType.PERSONAL,Transaction.Category.EXPENDITURE,5.55,123));
        transactions.add(new Transaction(LocalDate.now(),"netflix",BucketType.SUBSCRIPTIONS,Transaction.Category.EXPENDITURE,12,123));
        transactions.add(new Transaction(LocalDate.now(),"house",BucketType.HOUSING,Transaction.Category.EXPENDITURE,250,123));
        transactions.add(new Transaction(LocalDate.now(),"internet",BucketType.INTERNET,Transaction.Category.EXPENDITURE,10,123));
        transactions.add(new Transaction(LocalDate.now(),"gas",BucketType.UTILITIES,Transaction.Category.EXPENDITURE,5.55,123));
        transactions.add(new Transaction(LocalDate.now(),"crypto investment",BucketType.INVESTMENTS,Transaction.Category.EXPENDITURE,5.55,123));
        transactions.add(new Transaction(LocalDate.now(),"ER visit",BucketType.MEDICAL,Transaction.Category.EXPENDITURE,5.55,123));
        BankAccount.setAllTransactions(transactions);
        BankAccount.setAccountTotal();

        launch();
    }
}