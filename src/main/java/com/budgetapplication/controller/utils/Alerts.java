package com.budgetapplication.controller.utils;

import javafx.scene.control.Alert;
import javafx.scene.text.Text;

/**
 * Alerts is a utility class used by the controllers to display alert specific information for login
 * and data entry errors. It contains methods that are called on when the data entry or application
 * navigation is invalid.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class Alerts {

    /**
     * This method defines an alert that is displayed when a user enters an incorrect username and password.
     */
    public static void loginError(){
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        alertInfo.setTitle("Password Error");
        alertInfo.setHeaderText("Incorrect Username or Password");
        alertInfo.setContentText("Enter valid Username and Password");
        alertInfo.showAndWait();
    }

    /**
     * This method displays an informational text in regard to the "Allocation Info" label and why it's there.
     */
    public static void allocationInfo(){
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        alertInfo.setTitle("Allocation Running Total");
        alertInfo.setHeaderText("Allocation Running Total");
        alertInfo.setContentText("The sum of all allocation settings must equal 100% before you can proceed from this page. " +
                "Please review all settings and click \"Save Bucket Updates\" if you are satisfied");
        alertInfo.showAndWait();
    }

    /**
     * This method displays an alert notifying the user that fields are either empty or contain invalid data.
     */
    public static void missingInputData(){
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        alertInfo.setTitle("Missing input data");
        alertInfo.setHeaderText("Missing Input");
        alertInfo.setContentText("Please ensure all fields are completed with correct values before saving");
        alertInfo.showAndWait();
    }

    /**
     * This method displays an alert notifying the user that the allocations are not set properly and need to be set
     * and saved prior to moving from the page.
     */
    public static void allocationInfoIncorrect(){
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        alertInfo.setTitle("Allocation Info Needs to Be Set");
        alertInfo.setHeaderText("Allocation Info Needs to Be Set");
        alertInfo.setContentText("The sum of all allocation settings must equal 100% before you can proceed from this page. " +
                "Please review all settings and click \"Save Bucket Updates\" if you are satisfied");
        alertInfo.showAndWait();
    }

    /**
     * This method displays an alert notifying the user that the save function completed correctly.
     */
    public static void allocationsSet(){
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        alertInfo.setTitle("Save Successful");
        alertInfo.setHeaderText("Allocation Updates Saved");
        alertInfo.setContentText("Your allocations have been successfully updated");
        alertInfo.showAndWait();
    }
}
