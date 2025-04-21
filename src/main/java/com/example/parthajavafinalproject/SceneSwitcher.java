package com.example.parthajavafinalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    private static Stage stage; // Ensure this is set before switching scenes

    // Set the stage from the main application
    public static void setStage(Stage stage) {
        SceneSwitcher.stage = stage;
    }

    // Switch to a new scene
    public static void switchTo(String fxmlFileName) throws IOException {
        if (stage == null) {
            throw new IllegalStateException("Stage has not been set. Call setStage() first.");
        }

        try {
            Parent root = FXMLLoader.load(SceneSwitcher.class.getResource(fxmlFileName + ".fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); // Don't forget to show the stage
        } catch (IOException e) {
            System.out.println("Error loading scene: " + fxmlFileName);
            e.printStackTrace();
            throw e; // Propagate the exception after logging
        }
    }
}