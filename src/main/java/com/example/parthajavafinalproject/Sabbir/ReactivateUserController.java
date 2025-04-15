package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ReactivateUserController {
    @FXML
    private ComboBox<String> disabledUserComboBox;
    @FXML
    private Button reactivateButton;

    public ComboBox<String> getDisabledUserComboBox() {
        return disabledUserComboBox;
    }

    public void setDisabledUserComboBox(ComboBox<String> disabledUserComboBox) {
        this.disabledUserComboBox = disabledUserComboBox;
    }

    public Button getReactivateButton() {
        return reactivateButton;
    }

    public void setReactivateButton(Button reactivateButton) {
        this.reactivateButton = reactivateButton;
    }
}
