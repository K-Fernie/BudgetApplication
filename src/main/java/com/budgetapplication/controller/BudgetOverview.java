package com.budgetapplication.controller;


import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.budgetapplication.model.BankAccount.findLabelValue;


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

        housingLbl.setText("Housing: $" + findLabelValue(BucketType.HOUSING));
        transportLbl.setText("Transportation: $" + findLabelValue(BucketType.TRANSPORTATION));
        groceriesLbl.setText("Groceries: $" + findLabelValue(BucketType.GROCERIES));
        utilitiesLbl.setText("Utilities: $" + findLabelValue(BucketType.UTILITIES));
        subscriptionsLbl.setText("Subscriptions: $" + findLabelValue(BucketType.SUBSCRIPTIONS));
        investmentsLbl.setText("Investements: $" + findLabelValue(BucketType.INVESTMENTS));
        medicalLbl.setText("Medical: $" + findLabelValue(BucketType.MEDICAL));
        internetLbl.setText("Internet: $" + findLabelValue(BucketType.INTERNET));
        personalLbl.setText("Personal: $" + findLabelValue(BucketType.PERSONAL));
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));
    }
}
