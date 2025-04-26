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


    @FXML
    private void handleAddProductOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/AddProduct");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Add Product scene.");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleCheckStockOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/CheckProductStock");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Check Product Stock scene.");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleUpdateProductOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/UpdateProductDetails");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Update Product Details scene.");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleMonthlyReportOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/MonthlyReport");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Monthly Report scene.");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleDeliveredHistoryOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/DeliveredHistory");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Delivered History scene.");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleCheckRequestsOnClick() {

        try {

            SceneSwitcher.switchTo("Sabbir/CheckSupplyRequests");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Check Supply Requests scene.");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleConfirmDeliveryOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/ConfirmDelivery");
        } catch (IOException e) {

            showAlert("Error", "Failed to load Confirm Delivery scene.");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleDeletedProductOnClick() {
        try {

            SceneSwitcher.switchTo("Sabbir/DeleteProduct");
        } catch (IOException e) {

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