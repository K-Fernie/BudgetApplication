package com.budgetapplication.controller;
import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static com.budgetapplication.model.BankAccount.findBucketValue;

/**
 * Budget overview is a controller class to be used in conjunction with budget-overview.fxml.
 * It contains event methods used when a user clicks buttons on the screen. Extends initializable and
 * has data pulled from the bucket-info.csv file to display.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class BudgetOverview implements Initializable {

    static Parent scene;
    static Stage stage;

    @FXML
    private Label accountTotalLbl;

    @FXML
    private Label groceriesLbl;

    @FXML
    private Label housingLbl;

    @FXML
    private Label internetLbl;

    @FXML
    private Label investmentsLbl;

    @FXML
    private Label medicalLbl;

    @FXML
    private Label personalLbl;

    @FXML
    private Label subscriptionsLbl;

    @FXML
    private Label transportLbl;

    @FXML
    private Label utilitiesLbl;

    /**
     * When this button is clicked, the event moves the scene from budget-overview.fxml to enter-transaction.fxml
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
     * @throws IOException -
     */
    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        Transactions.writeTransactions();
        Buckets.writeTransactions();
        SceneHandling.sceneChanger(event, "login-screen.fxml", "Login Screen");

    }

    /**
     * When this button is clicked, the event moves the scene from budget-overview.fxml to set-budget-buckets.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickSetAllocations(ActionEvent event) {
        SceneHandling.sceneChanger(event, "set-budget-buckets.fxml", "Set Allocations");

    }

    /**
     * When this button is clicked, the event moves the scene from budget-overview.fxml to transaction-overview.fxml.
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickTransactionPage(ActionEvent event) {
        SceneHandling.sceneChanger(event, "transaction-overview.fxml", "Transaction Overview");

    }

    /**
     * The initialize method is inherited from the Initializable class. This method is used to set the various lables
     * with data display associated with either buckets or account totals.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        housingLbl.setText("Housing: $" + findBucketValue(BucketType.HOUSING));
        transportLbl.setText("Transportation: $" + findBucketValue(BucketType.TRANSPORTATION));
        groceriesLbl.setText("Groceries: $" + findBucketValue(BucketType.GROCERIES));
        utilitiesLbl.setText("Utilities: $" + findBucketValue(BucketType.UTILITIES));
        subscriptionsLbl.setText("Subscriptions: $" + findBucketValue(BucketType.SUBSCRIPTIONS));
        investmentsLbl.setText("Investements: $" + findBucketValue(BucketType.INVESTMENTS));
        medicalLbl.setText("Medical: $" + findBucketValue(BucketType.MEDICAL));
        internetLbl.setText("Internet: $" + findBucketValue(BucketType.INTERNET));
        personalLbl.setText("Personal: $" + findBucketValue(BucketType.PERSONAL));
        accountTotalLbl.setText(String.valueOf(BankAccount.getAccountTotal()));

    }
}
