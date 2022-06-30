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

/**
 * Budget overview is a controller class to be used in conjunction with transaction-overview.fxml.
 * It contains event methods used when a user clicks buttons on the screen. Extends initializable and
 * has data pulled from the bucket-info.csv file to display.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
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

    @FXML
    private TableColumn<Transaction, String> typeCol;

    /**
     * When this button is clicked, the event moves the scene from transaction-overview.fxml to budget-overview.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickBudgetOverview(ActionEvent event) {
        SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");

    }

    /**
     * When this button is clicked, the event moves the scene from transaction-overview.fxml to enter-transaction.fxml
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
     * When this button is clicked, the event moves the scene from transaction-overview.fxml to set-budget-buckets.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickSetAllocations(ActionEvent event) {
        SceneHandling.sceneChanger(event, "set-budget-buckets.fxml", "Set Allocations");

    }

    /**
     * When this button is clicked, the event moves the scene from transaction-overview.fxml to transaction-overview.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickTransactionPage(ActionEvent event) {
        SceneHandling.sceneChanger(event, "transaction-overview.fxml", "Transaction Overview");

    }

    /**
     * When this button is clicked it obtains the transaction object that has been selected from the table veiw and
     * goes through the process of removing it from the BankAccount array, updating bucket and account total data, and
     * re-setting the table view with the new array values.
     * @param event
     */
    @FXML
    void onActionRemoveTransaction(ActionEvent event) {
        Transaction transaction = transactionTableView.getSelectionModel().getSelectedItem();
        allTransactions.remove(transaction);
        BankAccount.removeTransactionUpdateBuckets(transaction);
        BankAccount.setAccountTotal();
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));
    }

    /**
     * The initialize method is inherited from the Initializable class. This method sets the initial table view information
     * with the ObservableArray of transactions obtained from the BankAccount. It also contains search text functionality
     * that resets the table view based on user input in the searchTxt field.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
                return transaction.getCategory().toString().toLowerCase().contains(lowerCaseFilter) ||
                        transaction.getDescription().toLowerCase().contains(lowerCaseFilter);
            });
        });

        SortedList<Transaction> sortedTransaction = new SortedList<>(filteredTransactions);
        sortedTransaction.comparatorProperty().bind(transactionTableView.comparatorProperty());
        transactionTableView.setItems(sortedTransaction);
        transactionTableView.setPlaceholder(new Label("No transactions were found"));
    }

}

