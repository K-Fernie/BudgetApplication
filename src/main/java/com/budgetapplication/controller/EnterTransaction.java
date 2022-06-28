package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));
        //filter these lists to show the first 9 categories if Expenditure is selected
        //filter to show the last 9 categories if Income is selected
        categoryCB.setVisibleRowCount(9);
        categoryCB.setItems(BucketType.getBucketTypes());

    }
}
