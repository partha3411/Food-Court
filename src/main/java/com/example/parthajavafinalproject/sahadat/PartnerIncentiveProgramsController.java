package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class PartnerIncentiveProgramsController {
    @javafx.fxml.FXML
    private Label statusLabel1;
    @javafx.fxml.FXML
    private ListView incentiveList;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void handleOptIn(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void partnerDashboard(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sahadat/partnerDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }
}
