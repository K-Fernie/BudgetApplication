package com.budgetapplication.controller.utils;

import javafx.scene.control.Alert;

public class Alerts {

    static Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

    public static void loginError(){
        alertInfo.setTitle("Password Error");
        alertInfo.setHeaderText("Incorrect Username or Password");
        alertInfo.setContentText("Enter valid Username and Password");
        alertInfo.showAndWait();
    }
}
