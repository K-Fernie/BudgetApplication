package com.budgetapplication.controller.utils;

import com.budgetapplication.main.BudgetAppClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * SceneHandling is a utility class used to manage the changing of screens. It contains a single method that
 * can be utilized for handling the scene changes.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class SceneHandling {

    static Parent scene;
    static Stage stage;

    /**
     * This method accepts an event, resource, that are used when defining the new scene that the event prompting
     * the application to display.
     * @param event - a certain event in the application (i.e. button click, enter key etc.)
     * @param resource - the .fxml screen that the scene will switch to.
     * @param title - the title displayed on the top of the screen.
     */
    public static void sceneChanger(ActionEvent event, String resource, String title) {

        try{
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Objects.requireNonNull(BudgetAppClient.class.getResource(resource)));
        stage.setTitle(title);
        stage.setScene(new Scene(scene));
        stage.show();}
        catch (IOException e)
        {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}
