package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UpdateProductController {
    @FXML
    private TextField productNameField;
    @FXML
    private TextField priceField;
    @FXML
    private Button updateButton;
    @FXML
    private ComboBox<String> productComboBox;
    @FXML
    private TextField quantityField;

    public TextField getProductNameField() {
        return productNameField;
    }

    public void setProductNameField(TextField productNameField) {
        this.productNameField = productNameField;
    }

    public TextField getQuantityField() {
        return quantityField;
    }

    public void setQuantityField(TextField quantityField) {
        this.quantityField = quantityField;
    }

    public ComboBox<String> getProductComboBox() {
        return productComboBox;
    }

    public void setProductComboBox(ComboBox<String> productComboBox) {
        this.productComboBox = productComboBox;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }

    public TextField getPriceField() {
        return priceField;
    }

    public void setPriceField(TextField priceField) {
        this.priceField = priceField;
    }
}
