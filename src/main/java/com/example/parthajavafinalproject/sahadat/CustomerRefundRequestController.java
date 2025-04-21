package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerRefundRequestController {
    @FXML
    private Label label1;
    @FXML
    private TextArea reasonTextArea;
    @FXML
    private ComboBox<String> orderComboBox;


    @FXML
    public void initialize() {
        orderComboBox.getItems().addAll("Pizza", "Burger", "Sushi", "Taco");
    }

    @FXML
    public void handleSubmitRefund(ActionEvent actionEvent) {

        label1.setText("Submitted");
    }

    @FXML
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
