package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PartnerDeliveryRequestController {

    @javafx.fxml.FXML
    private AnchorPane TF2;
    @javafx.fxml.FXML
    private Label label1;
    @javafx.fxml.FXML
    private Label label2;
    @javafx.fxml.FXML
    private Label label3;
    @javafx.fxml.FXML
    private Label label4;


    @javafx.fxml.FXML
    public void initialize() {
        label1.setText("Restaurant: Pizza Palace");
        label2.setText("Pickup Location: 123 Main Street");
        label3.setText("Earning: 750TK");
        label4.setText(""); // Start with empty status
    }

    @javafx.fxml.FXML
    public void partnerDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("sahadat/partnerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }

    @javafx.fxml.FXML
    public void declineButton(ActionEvent actionEvent) {
        label4.setText("Order Rejected");
    }

    @javafx.fxml.FXML
    public void acceptButton(ActionEvent actionEvent) {
        label4.setText("Order Accepted");
    }
}
