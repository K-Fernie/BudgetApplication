package com.budgetapplication.controller.utils;

import javafx.scene.control.Alert;
import javafx.scene.text.Text;

public class Alerts {

    static Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
    static Text text = new Text();

    public static void loginError(){
        alertInfo.setTitle("Password Error");
        alertInfo.setHeaderText("Incorrect Username or Password");
        alertInfo.setContentText("Enter valid Username and Password");
        alertInfo.showAndWait();
    }

    public static void allocationInfo(){
        alertInfo.setTitle("Allocation Running Total");
        alertInfo.setHeaderText("Allocation Running Total");
        text = new Text("The running total shows you how much percent of your income has been allocated. " +
                "The allocation sum must be equal to 100% before you can proceed from this page.");
        text.setWrappingWidth(350);
        alertInfo.getDialogPane().setContent(text);
        alertInfo.showAndWait();
    }

    public static void missingInputData(){
        alertInfo.setTitle("Missing input data");
        alertInfo.setHeaderText("Missing Input");
        alertInfo.setContentText("Please ensure all fields are completed before saving");
        alertInfo.showAndWait();
    }
}
