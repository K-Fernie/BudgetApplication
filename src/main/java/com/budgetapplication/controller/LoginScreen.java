package com.budgetapplication.controller;

import com.budgetapplication.controller.utils.Alerts;
import com.budgetapplication.controller.utils.SceneHandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginScreen {

    String userNameStor = "kfernelius";
    String passwordStor = "password1";

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    void onActionLoginBtn(ActionEvent event) throws IOException {
        //TODO connect and query the database for the correct password and username
       String userName = userNameTxt.getText();
       String password = passwordTxt.getText();

       if(userName.equals(userNameStor) && password.equals(passwordStor)){
           SceneHandling.sceneChanger(event, "budget-overview.fxml", "Budget Overview");
       }else{
           Alerts.loginError();
       }


    }

}
