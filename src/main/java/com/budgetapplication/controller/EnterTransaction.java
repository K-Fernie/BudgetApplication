package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EnterTransaction implements Initializable {
    @FXML
    private Label accountTotalLbl;

    @FXML
    private TextField amountTxt;

    @FXML
    private ComboBox<BucketType> categoryCB;

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
        try {

            Transaction.Category type = (income.getSelectedToggle() == incomeRad) ? Transaction.Category.INCOME : Transaction.Category.EXPENDITURE;
            LocalDate date = datePicker.getValue();
            BucketType category = categoryCB.getSelectionModel().getSelectedItem();
            String description = descriptionTxt.getText();
            double amount = Double.parseDouble(amountTxt.getText());
            //TODO update bankId to make sense in the context of the active user
            int bankId = 123;

            Transaction toAdd = new Transaction(date, description, category, type, amount, bankId);
            BankAccount.addTransaction(toAdd);
            BankAccount.updateBuckets(toAdd);
            accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));

        } catch (Exception e) {
            Alerts.missingInputData();
        }

        datePicker.getEditor().clear();
        categoryCB.getSelectionModel().clearSelection();
        descriptionTxt.clear();
        amountTxt.clear();
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
    void onSelectedExpenditure(ActionEvent event) {
        ObservableList<BucketType> cbExpenditure = FXCollections.observableArrayList();
        cbExpenditure.add(BucketType.HOUSING);
        cbExpenditure.add(BucketType.TRANSPORTATION);
        cbExpenditure.add(BucketType.GROCERIES);
        cbExpenditure.add(BucketType.UTILITIES);
        cbExpenditure.add(BucketType.SUBSCRIPTIONS);
        cbExpenditure.add(BucketType.INVESTMENTS);
        cbExpenditure.add(BucketType.MEDICAL);
        cbExpenditure.add(BucketType.INTERNET);
        cbExpenditure.add(BucketType.PERSONAL);
        categoryCB.setItems(cbExpenditure);

    }

    @FXML
    void onSelectedIncome(ActionEvent event) {
        ObservableList<BucketType> cbIncome = FXCollections.observableArrayList();
        cbIncome.add(BucketType.PAYCHECK);
        cbIncome.add(BucketType.GIFT);
        categoryCB.setItems(cbIncome);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));
        categoryCB.setVisibleRowCount(9);
        ObservableList<BucketType> cbIncome = FXCollections.observableArrayList();
        cbIncome.add(BucketType.PAYCHECK);
        cbIncome.add(BucketType.GIFT);
        categoryCB.setItems(cbIncome);

    }
}
