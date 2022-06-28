package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import com.budgetapplication.model.BankAccount;
import com.budgetapplication.model.Buckets;
import com.budgetapplication.model.User;
import com.budgetapplication.model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginScreen {

    User userLogin;
    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    void onActionLoginBtn(ActionEvent event) throws IOException {
        //TODO connect and query the database for the correct password and username
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
            SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
        } else {
            Alerts.loginError();
        }
    }

    private boolean login() throws IOException {
        Users.readUsers();
        return Users.find(userLogin.getUserLogin(), userLogin.getPassword());
    }

}
