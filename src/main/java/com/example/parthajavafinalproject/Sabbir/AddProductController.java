package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.BinaryFileHelper;
import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class AddProductController {

    @FXML
    private TextField productNameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;
    @FXML
    private Button addButton;

    private static final File PRODUCT_FILE = new File("products.bin");
    @FXML
    private void addProductOnClick() {

        String productName = productNameField.getText();
        String priceText = priceField.getText();
        String quantityText = quantityField.getText();


        if (productName.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        try {

            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);


            Product newProduct = new Product(productName, price, quantity);


            BinaryFileHelper.saveObject(PRODUCT_FILE, newProduct);


            showAlert("Success", "Product added successfully!");


            clearFields();
        } catch (NumberFormatException e) {

            showAlert("Error", "Please enter valid numeric values for price and quantity.");
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void clearFields() {
        productNameField.clear();
        priceField.clear();
        quantityField.clear();
    }


    @FXML
    private void backButtonOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/ProductSupplierDashboard");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Add Product scene.");
            e.printStackTrace();
        }
    }
}