package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.SceneHandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EnterTransaction {
    @FXML
    private Label accountTotalLbl;

    @FXML
    private TextField amountTxt;

    @FXML
    private ComboBox<?> categoryCB;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private RadioButton expenditureRad;

    @FXML
    private ToggleGroup income;

    @FXML
    private RadioButton incomeRad;

    @FXML
    void onActionSaveBtn(ActionEvent event) {

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
