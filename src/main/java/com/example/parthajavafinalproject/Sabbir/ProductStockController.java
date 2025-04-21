package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.BinaryFileHelper;
import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductStockController {

    @FXML
    private TableView<Product> stockTable;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Integer> quantityColumn;

    private static final File PRODUCT_FILE = new File("products.bin");

    @FXML
    public void initialize() {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Load products into the TableView
        loadProductStock();
    }

    // Method to load products from the binary file and display them in the TableView
    private void loadProductStock() {

        List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);

        ObservableList<Product> productList = FXCollections.observableArrayList(products);

        stockTable.setItems(productList);
    }

    @FXML
    private void backButtonOnClick() {
        try {
            SceneSwitcher.switchTo("Sabbir/ProductSupplierDashboard");
        } catch (IOException e) {
            showAlert("Error", "Failed to load previous scene.");
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}