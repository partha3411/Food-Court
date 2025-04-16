package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class DeleteProductController {
    @FXML
    private Button deleteButton;
    @FXML
    private ComboBox<String>  productComboBox;

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public ComboBox<String> getProductComboBox() {
        return productComboBox;
    }

    public void setProductComboBox(ComboBox<String> productComboBox) {
        this.productComboBox = productComboBox;
    }
}
