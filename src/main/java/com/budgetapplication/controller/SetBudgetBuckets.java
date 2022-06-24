package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.SceneHandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SetBudgetBuckets {

    @FXML
    void onClickBudgetOverview(ActionEvent event) {
        SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");

    }

    @FXML
    void onClickEnterExpenditure(ActionEvent event) {
        SceneHandling.sceneChanger(event, "enter-expenditure.fxml", "Enter Expenditure");
    }

    @FXML
    void onClickEnterIncome(ActionEvent event) {
        SceneHandling.sceneChanger(event, "enter-income.fxml", "Enter Income");
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
