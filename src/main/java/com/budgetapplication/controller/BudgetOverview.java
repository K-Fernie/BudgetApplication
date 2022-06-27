package com.budgetapplication.controller;


import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.main.BudgetAppClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BudgetOverview {
    static Parent scene;
    static Stage stage;

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
    void onClickEnterExpenditure(ActionEvent event) {
        SceneHandling.sceneChanger(event, "enter-expenditure.fxml", "Enter Expenditure");
    }

    @FXML
    void onClickEnterIncome(ActionEvent event) {
        SceneHandling.sceneChanger(event, "enter-income.fxml", "Enter Income");

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

}
