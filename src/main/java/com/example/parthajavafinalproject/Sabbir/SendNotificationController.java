package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendNotificationController {

    @FXML
    private TextField titleField;
    @FXML
    private Button sendButton;
    @FXML
    private ComboBox<String> targetComboBox;
    @FXML
    private TextArea messageArea;

    public TextField getTitleField() {
        return titleField;
    }

    public void setTitleField(TextField titleField) {
        this.titleField = titleField;
    }

    public Button getSendButton() {
        return sendButton;
    }

    public void setSendButton(Button sendButton) {
        this.sendButton = sendButton;
    }

    public ComboBox<String> getTargetComboBox() {
        return targetComboBox;
    }

    public void setTargetComboBox(ComboBox<String> targetComboBox) {
        this.targetComboBox = targetComboBox;
    }

    public TextArea getMessageArea() {
        return messageArea;
    }

    public void setMessageArea(TextArea messageArea) {
        this.messageArea = messageArea;
    }
}
