package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SetBudgetBuckets {
    @FXML
    private TextField GroceriesTxt;

    @FXML
    private Label accountTotalLbl;

    @FXML
    private Button buttonLbl;

    @FXML
    private Label groceriesLbl;

    @FXML
    private Label housingLbl;

    @FXML
    private TextField housingTxt;

    @FXML
    private Label internetLbl;

    @FXML
    private TextField internetTxt;

    @FXML
    private TextField internetTxt1;

    @FXML
    private Label investmentsLbl;

    @FXML
    private TextField investmentsTxt;

    @FXML
    private Label medicalLbl;

    @FXML
    private TextField medicalTxt;

    @FXML
    private Label personalLbl;

    @FXML
    private Label subscriptionsLbl;

    @FXML
    private TextField subscriptionsTxt;

    @FXML
    private Label transportLbl;

    @FXML
    private TextField transportationTxt;

    @FXML
    private Label utilitiesLbl;

    @FXML
    private TextField utilitiesTxt;

    @FXML
    void onClickAllocationHelpTextBtn(ActionEvent event) {
        Alerts.allocationInfo();
    }

    @FXML
    void onClickBudgetOverview(ActionEvent event) {
        SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");

    }

    @FXML
    void onClickEnterTransaction(ActionEvent event) {
        SceneHandling.sceneChanger(event, "enter-transaction.fxml", "Enter Transaction");
    }

    @FXML
    void onClickLogOut(ActionEvent event) {
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
}
