package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * LoginScreen is a controller class to be used in conjunction with login-screen.fxml.
 * It contains event methods used when a user clicks buttons on the screen. Extends initializable and
 * has data pulled from the bucket-info.csv file to display.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class LoginScreen {

    User userLogin;
    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField userNameTxt;

    /**
     * When this button is clicked the login process begins, the data entered by the user is stored and compared
     * to all known users in the list. If the user login is successful the bucket information is obtained by querying the
     * bucket file to find the buckets associated with the user and the scene switches to the main screen if the users allocations are set.
     * If no user is found a login error is shown in an alert display stating that the login information was incorrect.
     * @param event - Listens for a button click event
     * @throws IOException - IO exception is thrown if a file is not found
     */
    @FXML
    void onActionLoginBtn(ActionEvent event) throws IOException {
        userLogin = new User(0, userNameTxt.getText(), passwordTxt.getText());
        if (login()) {
            Users.setActiveUser(userLogin.getUserLogin());
            try {
                Buckets.readBuckets();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BankAccount.setAllBuckets(Buckets.getBuckets());
            BankAccount.setAccountTotal();
            Transactions.readTransactions();
            BankAccount.setAllTransactions(Transactions.getTransactions());
            if (BankAccount.isAllocated()){
                SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
            }
            else{
                SceneHandling.sceneChanger(event, "set-budget-buckets.fxml", "Set Allocations");
                Alerts.allocationInfo();
            }

        } else {
            Alerts.loginError();
        }
    }

    /**
     * Method used by the onActionLoginfunction to read the user-info.csv
     * @return - returns associated user that matches the user input
     * @throws IOException - IO Exception is thrown if no file is found
     */
    private boolean login() throws IOException {
        Users.readUsers();
        return Users.find(userLogin.getUserLogin(), userLogin.getPassword());
    }

}
