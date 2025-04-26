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

        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        loadProducts();
    }


    private void loadProducts() {

        List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);


        ObservableList<Product> productList = FXCollections.observableArrayList(products);
        productTable.setItems(productList);


        ObservableList<String> productNames = FXCollections.observableArrayList();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        productComboBox.setItems(productNames);
    }


    @FXML
    private void deleteProductOnClick() {

        String selectedProductName = productComboBox.getValue();

        if (selectedProductName == null) {
            showAlert("Error", "Please select a product to delete.");
            return;
        }


        List<Product> products = BinaryFileHelper.readAllObjects(PRODUCT_FILE);

        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getName().equals(selectedProductName)) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct != null) {

            products.remove(selectedProduct);

            BinaryFileHelper.writeAllObjects(PRODUCT_FILE, products);


            showAlert("Success", "Product deleted successfully!");


            loadProducts();
        } else {
            showAlert("Error", "Failed to delete the selected product.");
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
}