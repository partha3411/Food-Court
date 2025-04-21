package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PartnerAvailabilityStatusController {

    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {

    }


    @Deprecated
    public void handleToggle(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void partnerDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sahadat/partnerDashboard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Partner Dashboard");
        stage.show();
    }

    @Deprecated
    public void availableButton(ActionEvent actionEvent) {

        label.setText("Food Delivery Partner Online");
    }

    @Deprecated
    public void unavailable(ActionEvent actionEvent) {
        label.setText("Food Delivery Partner Offline");
    }

    @javafx.fxml.FXML
    public void availabelButton(ActionEvent actionEvent) {
        label.setText("Food Delivery Partner Online");
    }

    @javafx.fxml.FXML
    public void Unavailable(ActionEvent actionEvent) {
        label.setText("Food Delivery Partner Offline");

    }
}
