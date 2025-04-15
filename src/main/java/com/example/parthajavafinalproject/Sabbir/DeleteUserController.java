package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class DeleteUserController {

    @FXML
    private Button deleteButton;
    @FXML
    private ComboBox<String> userComboBox;

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public ComboBox<String> getUserComboBox() {
        return userComboBox;
    }

    public void setUserComboBox(ComboBox<String> userComboBox) {
        this.userComboBox = userComboBox;
    }
}
