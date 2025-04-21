package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PartnerDeliverOrderController {

    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextField confirmationCodeField;
    @javafx.fxml.FXML
    private Button confirmDeliveryButton;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void handleConfirmDelivery(ActionEvent actionEvent) {
        String confirmationCode = confirmationCodeField.getText();


        if (confirmationCode != null && !confirmationCode.isEmpty()) {
            label.setText("Delivery Confirmed");
        } else {
            label.setText("Invalid Code! Please try again.");
        }
    }

    @javafx.fxml.FXML
    public void partnerDashboard(ActionEvent event) throws IOException {
        // Switch to the partner dashboard scene
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("sahadat/partnerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }
}
