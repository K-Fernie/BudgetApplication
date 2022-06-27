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
            Transaction newTransaction = new Transaction(datePicker.getValue(), descriptionTxt.getText(),
                    categoryCB.getValue(), type, Double.parseDouble(amountTxt.getText()), Users.getActiveUser().getBankId());
            Transactions.addTransactions(newTransaction);
        } catch (Exception e) {
            Alerts.missingInputData();
        }

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

    }
}
