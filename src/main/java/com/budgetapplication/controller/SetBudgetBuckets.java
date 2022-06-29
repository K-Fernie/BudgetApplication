package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.budgetapplication.model.BankAccount.findPercentageValue;

public class SetBudgetBuckets implements Initializable {

    private double percentageTotal;
    private final String btnString = "Allocation Running Total: %s%%";

    @FXML
    private Button allocationBtnLbl;

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
        if(BankAccount.isAllocated()) {
            SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
        } else{
            Alerts.allocationInfoIncorrect();
        }
    }

    @FXML
    void onClickEnterTransaction(ActionEvent event) {
        if (BankAccount.isAllocated()) {
            SceneHandling.sceneChanger(event, "enter-transaction.fxml", "Enter Transaction");
        } else {
            Alerts.allocationInfoIncorrect();
        }
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

        if (BankAccount.isAllocated()) {
            SceneHandling.sceneChanger(event, "transaction-overview.fxml", "Transaction Overview");
        } else {
            Alerts.allocationInfoIncorrect();
        }

    }

    @FXML
    void onClickSaveBucketUpdates(ActionEvent event) {
        if (BankAccount.isAllocated()) {
            BankAccount.updateBucketAllocations(BucketType.HOUSING, Double.parseDouble(housingTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.TRANSPORTATION, Double.parseDouble(transportationTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.GROCERIES,Double.parseDouble(groceriesTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.UTILITIES, Double.parseDouble(utilitiesTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.SUBSCRIPTIONS, Double.parseDouble(subscriptionsTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.INVESTMENTS, Double.parseDouble(investmentsTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.MEDICAL, Double.parseDouble(medicalTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.INTERNET, Double.parseDouble(internetTxt.getText()) / 100.0);
            BankAccount.updateBucketAllocations(BucketType.PERSONAL, Double.parseDouble(personalTxt.getText()) / 100.0);
        } else {
            Alerts.allocationInfoIncorrect();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Bucket bucket: BankAccount.getAllBuckets()){
            percentageTotal += bucket.getPercentage();
        }

        allocationBtnLbl.setText(String.format(btnString, percentageTotal * 100));
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));
        housingTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.HOUSING)));
        transportationTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.TRANSPORTATION)));
        groceriesTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.GROCERIES)));
        utilitiesTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.UTILITIES)));
        subscriptionsTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.SUBSCRIPTIONS)));
        investmentsTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.INVESTMENTS)));
        medicalTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.MEDICAL)));
        internetTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.INTERNET)));
        personalTxt.setText(String.format("%.2s", 100.0 * findPercentageValue(BucketType.PERSONAL)));


    }
}
