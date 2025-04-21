package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.BinaryFileHelper;
import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DeleteProductController {

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Double> priceColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;

    @FXML
    private ComboBox<String> productComboBox;

    @FXML
    private Button deleteButton;

    private static final File PRODUCT_FILE = new File("products.bin");

    @FXML
    public void initialize() {
        // Initialize columns with the properties of the Product class
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Load products into the TableView and ComboBox
        loadProducts();
    }

    // Method to load products from the binary file and display in the TableView and ComboBox
    private void loadProducts() {
        // Read all products from the binary file
        List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);

        // Create an ObservableList for TableView
        ObservableList<Product> productList = FXCollections.observableArrayList(products);
        productTable.setItems(productList);

        // Create an ObservableList for ComboBox (only product names)
        ObservableList<String> productNames = FXCollections.observableArrayList();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        productComboBox.setItems(productNames);
    }

    // Method to handle the "Delete Product" button click
    @FXML
    private void deleteProductOnClick() {
        // Get the selected product name from ComboBox
        String selectedProductName = productComboBox.getValue();

        if (selectedProductName == null) {
            showAlert("Error", "Please select a product to delete.");
            return;
        }

        // Read all products from the binary file
        List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);

        // Find the product that matches the selected product name
        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getName().equals(selectedProductName)) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct != null) {
            // Remove the selected product from the list
            products.remove(selectedProduct);

            // Save the updated product list back to the binary file
            BinaryFileHelper.writeAllObjects(PRODUCT_FILE, products);

            // Show success alert
            showAlert("Success", "Product deleted successfully!");

            // Reload the table and ComboBox after deletion
            loadProducts();
        } else {
            showAlert("Error", "Failed to delete the selected product.");
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

    // Method to handle the "Back" button click (Navigate to previous scene)
    @FXML
    private void backButtonOnClick() {
        try {
            // Switch to the ProductSupplierDashboard scene
            SceneSwitcher.switchTo("Sabbir/ProductSupplierDashboard");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load previous scene.");
            e.printStackTrace();
        }
    }
}