package com.budgetapplication.controller;


import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.budgetapplication.model.BankAccount.findBucketValue;


public class BudgetOverview implements Initializable {

    static Parent scene;
    static Stage stage;

    @FXML
    private Label accountTotalLbl;

    @FXML
    private Label groceriesLbl;

    @FXML
    private Label housingLbl;

    @FXML
    private Label internetLbl;

    @FXML
    private Label investmentsLbl;

    @FXML
    private Label medicalLbl;

    @FXML
    private Label personalLbl;

    @FXML
    private Label subscriptionsLbl;

    @FXML
    private Label transportLbl;

    @FXML
    private Label utilitiesLbl;


    @FXML
    void onClickEnterTransaction(ActionEvent event) {
        SceneHandling.sceneChanger(event, "enter-transaction.fxml", "Enter Transaction");
    }

    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        Transactions.writeTransactions();
        Buckets.writeTransactions();
        SceneHandling.sceneChanger(event, "login-screen.fxml", "Login Screen");

    }

    @FXML
    void onClickSetAllocations(ActionEvent event) {
        SceneHandling.sceneChanger(event, "set-budget-buckets.fxml", "Set Allocations");

    }

    @FXML
    void onClickTransactionPage(ActionEvent event) {
        SceneHandling.sceneChanger(event, "transaction-overview.fxml", "Transaction Overview");

    }

    @FXML
    void onClickGroceriesBucket(ActionEvent event) {

    }

    @FXML
    void onClickHousingBucket(ActionEvent event) {

    }

    @FXML
    void onClickInvestmentsBucket(ActionEvent event) {

    }

    @FXML
    void onClickMedicalBucket(ActionEvent event) {

    }

    @FXML
    void onClickPersonalBucket(ActionEvent event) {

    }

    @FXML
    void onClickTransportationBucket(ActionEvent event) {

    }

    @FXML
    void onClickUtilitiesBucket(ActionEvent event) {

    }

    @FXML
    void onclickSubscriptionsBucket(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        housingLbl.setText("Housing: $" + findBucketValue(BucketType.HOUSING));
        transportLbl.setText("Transportation: $" + findBucketValue(BucketType.TRANSPORTATION));
        groceriesLbl.setText("Groceries: $" + findBucketValue(BucketType.GROCERIES));
        utilitiesLbl.setText("Utilities: $" + findBucketValue(BucketType.UTILITIES));
        subscriptionsLbl.setText("Subscriptions: $" + findBucketValue(BucketType.SUBSCRIPTIONS));
        investmentsLbl.setText("Investements: $" + findBucketValue(BucketType.INVESTMENTS));
        medicalLbl.setText("Medical: $" + findBucketValue(BucketType.MEDICAL));
        internetLbl.setText("Internet: $" + findBucketValue(BucketType.INTERNET));
        personalLbl.setText("Personal: $" + findBucketValue(BucketType.PERSONAL));
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));


    }
}
