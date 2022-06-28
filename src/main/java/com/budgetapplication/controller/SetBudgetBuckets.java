package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.BankAccount;
import com.budgetapplication.model.BucketType;
import com.budgetapplication.model.Buckets;
import com.budgetapplication.model.Transactions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.budgetapplication.model.BankAccount.findPercentageValue;

public class SetBudgetBuckets implements Initializable {

    @FXML
    private TextField groceriesTxt;

    @FXML
    private Label accountTotalLbl;


    @FXML
    private TextField housingTxt;


    @FXML
    private TextField internetTxt;


    @FXML
    private TextField investmentsTxt;

    @FXML
    private TextField personalTxt;

    @FXML
    private TextField medicalTxt;

    @FXML
    private TextField subscriptionsTxt;


    @FXML
    private TextField transportationTxt;

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
    void onClickSaveBucketUpdates(ActionEvent event) {
        BankAccount.updateBucketAllocations(BucketType.HOUSING, Double.parseDouble(housingTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.TRANSPORTATION, Double.parseDouble(transportationTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.GROCERIES,Double.parseDouble(groceriesTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.UTILITIES, Double.parseDouble(utilitiesTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.SUBSCRIPTIONS, Double.parseDouble(subscriptionsTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.INVESTMENTS, Double.parseDouble(investmentsTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.MEDICAL, Double.parseDouble(medicalTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.INTERNET, Double.parseDouble(internetTxt.getText()));
        BankAccount.updateBucketAllocations(BucketType.PERSONAL, Double.parseDouble(personalTxt.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));

        //TODO, in findPercentageValue convert from decimal to number so that it displays better
        housingTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.HOUSING)));
        transportationTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.TRANSPORTATION)));
        groceriesTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.GROCERIES)));
        utilitiesTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.UTILITIES)));
        subscriptionsTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.SUBSCRIPTIONS)));
        investmentsTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.INVESTMENTS)));
        medicalTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.MEDICAL)));
        internetTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.INTERNET)));
        personalTxt.setPromptText(String.valueOf(findPercentageValue(BucketType.PERSONAL)));

    }
}
