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

/**
 * EnterTransaction is a controller class that extends Initializable to be used in conjunction with enter-transaction.fxml.
 * It contains event methods used when a user clicks buttons on the screen.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
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

    /**
     * When this button is clicked the event obtains the information from each of the fields present.
     * If the fields contain the appropriate data type the save succeeds and adds the newly created transaction to the
     * static observable list in BankAccount. On a failed save it alerts the user that data is configured incorrectly or is missing
     * @param event - Listens for a button click
     */
    @FXML
    void onActionSaveBtn(ActionEvent event) {
        try {

            Transaction.Category type = (income.getSelectedToggle() == incomeRad) ? Transaction.Category.INCOME : Transaction.Category.EXPENDITURE;
            LocalDate date = datePicker.getValue();
            BucketType category = categoryCB.getSelectionModel().getSelectedItem();
            String description = descriptionTxt.getText();
            double amount = Double.parseDouble(amountTxt.getText());
            int bankId = Users.getActiveUser().getBankId();

            Transaction toAdd = new Transaction(date, description, category, type, amount, bankId);
            BankAccount.addTransaction(toAdd);
            BankAccount.addTransactionUpdateBuckets(toAdd);
            accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));

        } catch (Exception e) {
            Alerts.missingInputData();
        }

        datePicker.getEditor().clear();
        categoryCB.getSelectionModel().clearSelection();
        descriptionTxt.clear();
        amountTxt.clear();
    }

    /**
     * When this button is clicked, the event moves the scene from enter-transaction.fxml to budget-overview.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickBudgetOverview(ActionEvent event) {
        SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
    }

    /**
     * When this button is clicked, the event moves the scene from enter-transaction.fxml to enter-transaction.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickEnterTransaction(ActionEvent event) {
        SceneHandling.sceneChanger(event, "enter-transaction.fxml", "Enter Transaction");
    }

    /**
     * When this button is clicked the Transactions and Buckets both utilize methods for the
     * Bucket and Transactions stored in the client.
     * The event moves the scene from budget-overview.fxml to login-screen.fxml.
     * @param event - Listens for a button click event.
     * @throws IOException - If data is not written correctly an IOException is thrown
     */
    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        Transactions.writeTransactions();
        Buckets.writeBuckets();
        SceneHandling.sceneChanger(event, "login-screen.fxml", "Login Screen");
    }

    /**
     * When this button is clicked, the event moves the scene from enter-transaction.fxml to set-budget-buckets.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickSetAllocations(ActionEvent event) {
        SceneHandling.sceneChanger(event, "set-budget-buckets.fxml", "Set Allocations");
    }

    /**
     * When this button is clicked, the event moves the scene from enter-transaction.fxml to transaction-overview.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickTransactionPage(ActionEvent event) {
        SceneHandling.sceneChanger(event, "transaction-overview.fxml", "Transaction Overview");
    }

    /**
     * This method is associated with the expenditure radio button. When selected it adds all BucketTypes associated with
     * expenditure to the observable array list contained in the categoryCB combobox.
     * @param event - Listens for a radio button selection
     */
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

    /**
     * This method is associated with the expenditure radio button. When selected it adds all BucketTypes associated with
     * income to the observable array list contained in the categoryCB combobox.
     * @param event - Listens for a radio button selection
     */
    @FXML
    void onSelectedIncome(ActionEvent event) {
        ObservableList<BucketType> cbIncome = FXCollections.observableArrayList();
        cbIncome.add(BucketType.PAYCHECK);
        cbIncome.add(BucketType.GIFT);
        categoryCB.setItems(cbIncome);

    }

    /**
     * The initialize method is inherited from the Initializable class. This method is used to set the account total label,
     * and categoryCB combobox with the values to be shown to and used by the user respectively.
     */
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
