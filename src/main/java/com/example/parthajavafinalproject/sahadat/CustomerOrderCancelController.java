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

public class CustomerOrderCancelController {

    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void cancelOrderButton(ActionEvent actionEvent) {
        label.setText("Order Canceled");
    }


    @javafx.fxml.FXML
    public void customerDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sahadat/customerDashboard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }
}
