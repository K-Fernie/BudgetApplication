package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
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
    void onActionLoginBtn(ActionEvent event) {
        //TODO connect and query the database for the correct password and username
        userLogin = new User(0, userNameTxt.getText(), passwordTxt.getText());
        if (login()) {
            Users.setActiveUser(userLogin.getUserLogin());
            SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
        } else {
            Alerts.loginError();
        }
    }

    private boolean login() {
        Users.readUsers();
        return Users.find(userLogin.getUserLogin(), userLogin.getPassword());
    }

}
