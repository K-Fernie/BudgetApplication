package com.budgetapplication.controller;


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

    }

    @FXML
    void onClickEnterIncome(ActionEvent event) {

    }

    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Objects.requireNonNull(BudgetAppClient.class.getResource("login-screen.fxml")));
        stage.setTitle("Budget Overview");
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickSetAllocations(ActionEvent event) {

    }

    @FXML
    void onClickTransactionPage(ActionEvent event) {

    }
}
