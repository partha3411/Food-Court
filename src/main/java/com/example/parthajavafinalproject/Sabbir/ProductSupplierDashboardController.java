package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

public class ProductSupplierDashboardController {

    @FXML
    private Button addProductButton;

    @FXML
    private Button checkStockButton;

    @FXML
    private Button updateProductButton;

    @FXML
    private Button monthlyReportButton;

    @FXML
    private Button deliveredHistoryButton;

    @FXML
    private Button checkRequestsButton;

    @FXML
    private Button confirmDeliveryButton;

    @FXML
    private Button deletedProductButton;

    @FXML
    private Button logOutButton;

    // Method to handle Add Product button click
    @FXML
    private void handleAddProductOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/AddProduct");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Add Product scene.");
            e.printStackTrace();
        }
    }

    // Method to handle Check Product Stock button click
    @FXML
    private void handleCheckStockOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/CheckProductStock");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Check Product Stock scene.");
            e.printStackTrace();
        }
    }

    // Method to handle Update Product button click
    @FXML
    private void handleUpdateProductOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/UpdateProductDetails");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Update Product Details scene.");
            e.printStackTrace();
        }
    }

    // Method to handle Monthly Report button click
    @FXML
    private void handleMonthlyReportOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/MonthlyReport");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Monthly Report scene.");
            e.printStackTrace();
        }
    }

    // Method to handle Delivered History button click
    @FXML
    private void handleDeliveredHistoryOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/DeliveredHistory");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Delivered History scene.");
            e.printStackTrace();
        }
    }

    // Method to handle Check Supply Requests button click
    @FXML
    private void handleCheckRequestsOnClick() {

        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/CheckSupplyRequests");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Check Supply Requests scene.");
            e.printStackTrace();
        }
    }

    // Method to handle Confirm Delivery button click
    @FXML
    private void handleConfirmDeliveryOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/ConfirmDelivery");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Confirm Delivery scene.");
            e.printStackTrace();
        }
    }

    // Method to handle Deleted Product button click
    @FXML
    private void handleDeletedProductOnClick() {
        try {
            // Switch to the AddProduct scene
            SceneSwitcher.switchTo("Sabbir/DeleteProduct");
        } catch (IOException e) {
            // Show an error alert if the scene cannot be loaded
            showAlert("Error", "Failed to load Delete Product scene.");
            e.printStackTrace();
        }
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) {
        try {
            SceneSwitcher.switchTo("loginScene");
        } catch (IOException e) {
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