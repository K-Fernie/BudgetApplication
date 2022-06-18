package com.budgetapplication.controller;

import com.budgetapplication.main.BudgetAppClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class LoginScreen {

    static Parent scene;
    static Stage stage;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    void onActionLoginBtn(ActionEvent event) throws IOException {
        //TODO query the database for the correct password and username
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Objects.requireNonNull(BudgetAppClient.class.getResource("budget-overview.fxml")));
        stage.setTitle("Budget Overview");
        stage.setScene(new Scene(scene));
        stage.show();
    }

}
