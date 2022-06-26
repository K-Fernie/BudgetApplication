package com.budgetapplication.controller;


import com.budgetapplication.controller.utils.SceneHandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class BudgetOverview {

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
        SceneHandling.sceneChanger(event, "enter-transaction.fxml", "Login Screen");
    }

    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
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

}
