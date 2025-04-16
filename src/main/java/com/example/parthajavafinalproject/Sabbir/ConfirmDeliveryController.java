package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class ConfirmDeliveryController {
    @FXML
    private Button confirmButton;
    @FXML
    private ComboBox<String> deliveryComboBox;

    public Button getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
    }

    public ComboBox<String> getDeliveryComboBox() {
        return deliveryComboBox;
    }

    public void setDeliveryComboBox(ComboBox<String> deliveryComboBox) {
        this.deliveryComboBox = deliveryComboBox;
    }
}
