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

    public static void allocationInfo(){
        alertInfo.setTitle("Allocation Running Total");
        alertInfo.setHeaderText("Allocation Running Total");
        alertInfo.setContentText("The running total shows you how much percent of your income has been allocated. " +
                "The allocation sum must be equal to 100% before you can proceed from this page." );
        alertInfo.showAndWait();
    }
}
