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
import java.time.LocalDate;

public class FireSafetyController {
    @FXML
    private DatePicker date;
    @FXML
    private ListView<String> showingalert;
    @FXML
    private TextField name;
    @FXML
    private Label alertMe;
    @FXML
    private ComboBox<String> equipment;

    @FXML
    public void initialize() {
        // Populate equipment options
        equipment.getItems().addAll(
                "Fire Extinguisher",
                "Fire Alarm",
                "Emergency Exit Light",
                "Smoke Detector"
        );
    }

    @FXML
    public void alertbutton(ActionEvent actionEvent) {
        String inspector = name.getText().trim();
        LocalDate expiry = date.getValue();
        String equip = equipment.getValue();

        // Basic input validation
        if (inspector.isEmpty() || expiry == null || equip == null) {
            alertMe.setText("⚠️ Please fill all fields: name, equipment, and date.");
            return;
        }

        // Create log entry
        String log = "🧯 " + equip + " inspected by " + inspector + " | Expiry: " + expiry;
        showingalert.getItems().add(log);
        LocalDate today = LocalDate.now();
        if (expiry.isBefore(today)) {
            alertMe.setText("🚨 ALERT: " + equip + " is EXPIRED!");
        } else if (expiry.isBefore(today.plusDays(30))) {
            alertMe.setText("⚠️ WARNING: " + equip + " expires soon.");
        } else {
            alertMe.setText("✅ " + equip + " is in good condition.");
        }

        // Optionally clear inputs
        name.clear();
        equipment.setValue(null);
        date.setValue(null);
    }

    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sojib/HealthTaskBar.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }
}
