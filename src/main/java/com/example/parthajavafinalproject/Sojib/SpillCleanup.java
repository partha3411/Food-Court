package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SpillCleanup {
    @javafx.fxml.FXML
    private ProgressBar Progression;
    @javafx.fxml.FXML
    private Label Status;
    @javafx.fxml.FXML
    private TextArea SpillDetails;
    @javafx.fxml.FXML
    private ListView<String> SpillZones;
    @javafx.fxml.FXML
    private ChoiceBox<String> choiceSeverity;

    private int cleanupCount = 0;

    @javafx.fxml.FXML
    public void initialize() {
        SpillZones.getItems().addAll(
                "Zone A - Cafeteria Entrance",
                "Zone B - Lobby Restroom",
                "Zone C - Loading Dock",
                "Zone D - Reception Hall",
                "Zone E - Hallway Near Room 204"
        );
        choiceSeverity.getItems().addAll("Minor", "Moderate", "Severe", "Hazardous");
        Status.setText("Pending");
        SpillZones.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                SpillDetails.setText("Cleaning required at: " + newVal);
            }
        });
    }
    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sojib/CleaningTasksController.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }
    @javafx.fxml.FXML
    public void CleanUpComplete(ActionEvent actionEvent) {
        int totalCleanups = 5;
        if (cleanupCount < totalCleanups) {
            cleanupCount++;
            double progress = (double) cleanupCount / totalCleanups;
            Progression.setProgress(progress);
            Status.setText("Cleaned: " + cleanupCount + " / " + totalCleanups);
        } else {
            Status.setText("All spills cleaned!");
        }
    }
    @javafx.fxml.FXML
    public void RespondSpill(ActionEvent actionEvent) {
        Status.setText("Status: Done!");
    }
}
