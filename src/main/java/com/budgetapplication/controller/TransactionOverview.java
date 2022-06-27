package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.BankAccount;
import com.budgetapplication.model.Transaction;
import com.budgetapplication.model.Transactions;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TransactionOverview implements Initializable {

    private static final ObservableList<Transaction> allTransactions = BankAccount.getAllTransactions();

    @FXML
    private Label accountTotalLbl;

    @FXML
    private TableColumn<Transaction, Double> amountCol;

    @FXML
    private TableColumn<Transaction, Transaction.Category> categoryCol;

    @FXML
    private TableColumn<Transaction, LocalDate> dateCol;

    @FXML
    private TableColumn<Transaction, String> descriptionCol;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<Transaction> transactionTableView;

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
    void onTypeSearch(InputMethodEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO fix the formatting of the Table View so the table doesn't look so trashy
        transactionTableView.setItems(allTransactions);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        //TODO implement search function to show an updated list for category/type
    }
}
