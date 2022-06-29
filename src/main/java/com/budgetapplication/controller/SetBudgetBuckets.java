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

/**
 * SetBudgetBuckets is a controller class to be used in conjunction with set-budget-buckets.fxml.
 * It contains event methods used when a user clicks buttons on the screen. Extends initializable and uses
 * data from the ObservableList in BankAccount.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
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

    /**
     * txtFieldSum is used to calculate the sum of all the double values entered into the fields.
     * @return - returns the sum value
     */
    private double txtFieldSum(){

        return Double.parseDouble(housingTxt.getText()) + Double.parseDouble(transportationTxt.getText()) + Double.parseDouble(groceriesTxt.getText())
                + Double.parseDouble(utilitiesTxt.getText()) + Double.parseDouble(subscriptionsTxt.getText()) + Double.parseDouble(investmentsTxt.getText()) +
                Double.parseDouble(medicalTxt.getText()) + Double.parseDouble(internetTxt.getText()) + Double.parseDouble(personalTxt.getText());

    }

    /**
     * The AllocationHelpTextBtn opens an alert box showing the user what the allocation button label should display in order
     * for the user to be able to navigate away from the page.
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickAllocationHelpTextBtn(ActionEvent event) {
        Alerts.allocationInfo();
    }

    /**
     * When this button is clicked the event checks that the allocations entered are equal to 100, if they are it navigates
     * to budget-overview.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickBudgetOverview(ActionEvent event) {
        if(txtFieldSum() == 100) {
            SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
        } else{
            Alerts.allocationInfoIncorrect();
        }
    }

    /**
     * When this button is clicked the event checks that the allocations entered are equal to 100, if they are it navigates
     * to enter-transaction.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickEnterTransaction(ActionEvent event) {
        if (txtFieldSum() == 100) {
            SceneHandling.sceneChanger(event, "enter-transaction.fxml", "Enter Transaction");
        } else {
            Alerts.allocationInfoIncorrect();
        }
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
     * When this button is clicked the event checks that the allocations entered are equal to 100, if they are it navigates
     * to set-budget-buckets.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickSetAllocations(ActionEvent event) {
        SceneHandling.sceneChanger(event, "set-budget-buckets.fxml", "Set Allocations");

    }

    /**
     * When this button is clicked the event checks that the allocations entered are equal to 100, if they are it navigates
     * to transaction-overview.fxml
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickTransactionPage(ActionEvent event) {

        if (BankAccount.isAllocated()) {
            SceneHandling.sceneChanger(event, "transaction-overview.fxml", "Transaction Overview");
        } else {
            Alerts.allocationInfoIncorrect();
        }

    }

    /**
     * When this button is clicked the event checks that the allocations entered are equal to 100, if they are
     * each text field is updated in the bucket allocation list stored in Bank Account. If they are not equal to
     * 100 an alert shows informing the user that the buckets need to be allocated properly before the user can save
     * @param event - Listens for a button click event
     */
    @FXML
    void onClickSaveBucketUpdates(ActionEvent event) {
        if (txtFieldSum() == 100) {
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

    /**
     * The initialize method is inherited from the Initializable class. This method is used to set the initial percentage display
     * in the text boxes so the user is aware of the current configuration of the bucket percenages.
     *
     * It also utilizes listeners to update data display ad hoc as users enter in new text information in the text fields
     */
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

        //TODO figure out how to make a listener for multiple text boxes right now we do it the long way and ooof this is SO REDUNDANT
        housingTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        transportationTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        groceriesTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        utilitiesTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        subscriptionsTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        investmentsTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        medicalTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        internetTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });

        personalTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                allocationBtnLbl.setText(String.format(btnString, txtFieldSum()));
            }
            catch (NumberFormatException e){
                //Do Nothing
            }
        });
    }
}
