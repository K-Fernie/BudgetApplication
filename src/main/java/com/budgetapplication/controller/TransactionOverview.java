package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.Transaction;
import com.budgetapplication.model.TransactionCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

import java.time.LocalDate;

public class TransactionOverview {

    @FXML
    private Label accountTotalLbl;

    @FXML
    private TableColumn<Transaction, Double> amountCol;

    @FXML
    private TableColumn<Transaction, TransactionCategory> categoryCol;

    @FXML
    private TableColumn<Transaction, LocalDate> dateCol;

    @FXML
    private TableColumn<Transaction, String> descriptionCol;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<?> transactionTableView;

    //TODO update this column with the correct type once it's created i.e. transaction type enum
    @FXML
    private TableColumn<Transaction, String> typeCol;

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

    @FXML
    void onTypeSearch(InputMethodEvent event) {

    }
}
