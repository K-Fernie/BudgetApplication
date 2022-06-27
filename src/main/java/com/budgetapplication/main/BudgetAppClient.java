package com.budgetapplication.main;

import com.budgetapplication.model.BankAccount;
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
        FXMLLoader fxmlLoader = new FXMLLoader(BudgetAppClient.class.getResource("transaction-overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Budget App Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        BankAccount act = new BankAccount(123, 1200.00);
        BankAccount.addTransaction(new Transaction(LocalDate.now(), "test", BucketType.GROCERIES, Transaction.Category.EXPENDITURE, 5.00, 123));
        launch();
    }
}