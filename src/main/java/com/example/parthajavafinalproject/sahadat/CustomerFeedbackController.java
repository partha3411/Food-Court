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

public class CustomerFeedbackController {
    @FXML
    private TextArea feedbackTextArea;
    @FXML
    private Label statusLB;
    @FXML
    private ComboBox<String> ratingCB;

    @FXML
    public void initialize() {

        ratingCB.getItems().addAll("1", "2", "3", "4", "5");
    }

    @FXML
    public void handleSubmitFeedback(ActionEvent actionEvent) {
        String feedback = feedbackTextArea.getText().trim();
        String rating = ratingCB.getValue();


        if (feedback.isEmpty() || rating == null) {
            statusLB.setText("Please enter feedback and select a rating.");
            return;
        }


        statusLB.setText("Comment Submitted");


        feedbackTextArea.clear();
        ratingCB.setValue(null);
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

    @FXML
    public void ratingButton(ActionEvent actionEvent) {

    }
}
