package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.BinaryFileHelper;
import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpdateProductController {

    @FXML
    private TextField productNameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;
    @FXML
    private ComboBox<String> productComboBox;
    @FXML
    private Button updateButton;

    private static final File PRODUCT_FILE = new File("products.bin");


    @FXML
    public void initialize() {
        loadProductsIntoComboBox();
    }


    private void loadProductsIntoComboBox() {
        List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);
        for (Product product : products) {
            productComboBox.getItems().add(product.getName());
        }

        productComboBox.setOnAction(event -> loadSelectedProduct());
    }

    private void loadSelectedProduct() {
        String selectedProductName = productComboBox.getValue();
        if (selectedProductName != null) {
            List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);
            for (Product product : products) {
                if (product.getName().equals(selectedProductName)) {
                    productNameField.setText(product.getName());
                    priceField.setText(String.valueOf(product.getPrice()));
                    quantityField.setText(String.valueOf(product.getQuantity()));
                    break;
                }
            }
        }
    }

    @FXML
    private void updateProductOnClick() {
        String selectedProductName = productComboBox.getValue();
        String newProductName = productNameField.getText();
        String priceText = priceField.getText();
        String quantityText = quantityField.getText();

        if (selectedProductName == null || newProductName.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        try {

            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);


            List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);
            Product updatedProduct = null;
            for (Product product : products) {
                if (product.getName().equals(selectedProductName)) {
                    updatedProduct = product;
                    break;
                }
            }

            if (updatedProduct != null) {

                updatedProduct.setName(newProductName);
                updatedProduct.setPrice(price);
                updatedProduct.setQuantity(quantity);

                BinaryFileHelper.writeAllObjects(PRODUCT_FILE, products);


                showAlert("Success", "Product updated successfully!");


                clearFields();
            }
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
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load previous scene.");
            e.printStackTrace();
        }
    }
}