package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class PartnerDeliveryIssueController {

    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    private ComboBox<String> customerCb;

    @javafx.fxml.FXML
    private TextArea tA;


    @javafx.fxml.FXML
    public void initialize() {
        customerCb.getItems().addAll(
                "Late delivery",
                "Wrong order delivered",
                "Missing items",
                "Food was cold",
                "Delivery driver was rude"
        );
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
    public void handleSubmit(ActionEvent actionEvent) {
        String selectedIssue = customerCb.getValue();
        String comment = tA.getText();

        if (selectedIssue == null || comment.trim().isEmpty()) {
            label.setText("Please select an issue and write a comment.");
        } else {
            // You can add code to save this to a file/database if needed
            label.setText("Submitted");

            customerCb.setValue(null);
            tA.clear();
        }
    }
}
