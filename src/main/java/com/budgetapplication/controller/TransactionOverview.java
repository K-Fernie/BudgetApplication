package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

    private static ObservableList<Transaction> allTransactions = BankAccount.getAllTransactions();

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
    void onTypeSearch(InputMethodEvent event) {

    }

    @FXML
    void onActionRemoveTransaction(ActionEvent event) {
        Transaction transaction = transactionTableView.getSelectionModel().getSelectedItem();
        allTransactions.remove(transaction);
        BankAccount.setAccountTotal();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Transactions.readTransactions();
            BankAccount.setAllTransactions(Transactions.getTransactions());
        } catch (IOException e) {
            e.printStackTrace();
        }

        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));

        try {
            allTransactions = BankAccount.getAllTransactions();
            transactionTableView.setItems(allTransactions);
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
            descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
            amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //TODO find a way to compartmentalize the sort function
        FilteredList<Transaction> filteredTransactions = new FilteredList<>(allTransactions, p -> true);

        searchTxt.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredTransactions.setPredicate(transaction ->
            {
                if(newValue == null || newValue.isEmpty())
                {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(transaction.getCategory().toString().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else
                    return false;
            });
        });

        SortedList<Transaction> sortedTransaction = new SortedList<>(filteredTransactions);
        sortedTransaction.comparatorProperty().bind(transactionTableView.comparatorProperty());
        transactionTableView.setItems(sortedTransaction);
        transactionTableView.setPlaceholder(new Label("No transactions were found"));
    }
        //TODO implement search function to show an updated list for category/type
}

