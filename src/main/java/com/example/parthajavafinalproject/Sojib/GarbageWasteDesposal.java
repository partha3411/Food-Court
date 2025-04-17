package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent; import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class GarbageWasteDesposal {

    @FXML
    private ProgressBar Progression;

    @FXML
    private TextArea TakeNote;

    @FXML
    private ListView<String> ListViewGarbage;

    @FXML
    private ChoiceBox<String> BinStatus;

    private int collectedBins = 0;
    private final int totalBins = 5;

    @FXML
    public void initialize() {

        ListViewGarbage.getItems().addAll(
                "Zone A - Near Cafeteria",
                "Zone B - Main Lobby",
                "Zone C - Office Entrance",
                "Zone D - Basement Exit",
                "Zone E - Parking Lot"
        );
        BinStatus.getItems().addAll(
                "Empty",
                "Half Full",
                "Full",
                "Overflowing"
        );
        BinStatus.getSelectionModel().selectFirst();
        ListViewGarbage.getSelectionModel().selectFirst();
        Progression.setProgress(0.0);
    }

    @FXML
    public void SubmitNotes(ActionEvent actionEvent) {
        String note = TakeNote.getText();
        String selectedZone = ListViewGarbage.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Notes Submitted");
        alert.setHeaderText("Note Recorded for " + selectedZone);
        alert.setContentText("Note: " + note);
        alert.showAndWait();
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

    @FXML
    public void BinStatusButton(ActionEvent actionEvent) {
        String selectedZone = ListViewGarbage.getSelectionModel().getSelectedItem();
        String selectedStatus = BinStatus.getValue();

        if (collectedBins < totalBins) {
            collectedBins++;
            double progress = (double) collectedBins / totalBins;
            Progression.setProgress(progress);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Status Updated");
            alert.setHeaderText("Bin Updated: " + selectedZone);
            alert.setContentText("Status: " + selectedStatus + "\nProgress: " + collectedBins + " / " + totalBins);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("All Bins Processed");
            alert.setHeaderText("You have updated all bins!");
            alert.setContentText("Total: " + totalBins);
            alert.showAndWait();
        }
    }
}