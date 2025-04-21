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

    private static final File PRODUCT_FILE = new File("products.bin"); // The file to store products

    // Method to handle Add Product button click
    @FXML
    private void addProductOnClick() {
        // Get input from the fields
        String productName = productNameField.getText();
        String priceText = priceField.getText();
        String quantityText = quantityField.getText();

        // Check if any field is empty
        if (productName.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        try {
            // Parse price and quantity to double and int
            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);

            // Create a new Product object
            Product newProduct = new Product(productName, price, quantity);

            // Save the new product to the binary file
            BinaryFileHelper.saveObject(PRODUCT_FILE, newProduct);

            // Show success alert
            showAlert("Success", "Product added successfully!");

            // Clear input fields
            clearFields();
        } catch (NumberFormatException e) {
            // Handle invalid number format for price or quantity
            showAlert("Error", "Please enter valid numeric values for price and quantity.");
        }
    }

    // Method to show alert messages
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to clear all input fields
    private void clearFields() {
        productNameField.clear();
        priceField.clear();
        quantityField.clear();
    }

    // Method to handle the "Back" button click (if needed for navigation)
    @FXML
    private void backButtonOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/ProductSupplierDashboard");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Add Product scene.");
            e.printStackTrace();
        }
    }
}