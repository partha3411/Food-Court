package com.example.parthajavafinalproject.sahadat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class CustomerFeedbackController {
    @javafx.fxml.FXML
    private Label statusLabel1;
    @javafx.fxml.FXML
    private VBox feedbackContainer;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TextArea feedbackTextArea;
    @javafx.fxml.FXML
    private ComboBox ratingComboBox;
    @javafx.fxml.FXML
    private Label statusLabel3;
    @javafx.fxml.FXML
    private Label statusLabel2;

    @javafx.fxml.FXML
    public void handleSubmitFeedback(ActionEvent actionEvent) {
    }
}
