package com.budgetapplication.controller.utils;

import com.budgetapplication.main.BudgetAppClient;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneHandling {

    static Parent scene;
    static Stage stage;


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
