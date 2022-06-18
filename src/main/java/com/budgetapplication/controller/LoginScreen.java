package com.budgetapplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginScreen {


    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    void onActionLoginBtn(ActionEvent event) throws IOException {
        //TODO query the database for the correct password and username
       String userName = userNameTxt.getText();
       String password = passwordTxt.getText();

       SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
    }

}
