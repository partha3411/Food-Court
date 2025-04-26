package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private void handleCreateUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/CreateUser");
    }

    @FXML
    private void handleUserActivityButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/UserActivity");
    }

    @FXML
    private void handleSalesReportButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/SalesReport");
    }

    @FXML
    private void handleUpdateUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/UpdateUser");
    }

    @FXML
    private void handleLogOutButton(ActionEvent event) {

        System.out.println("Logging out...");

    }

    @FXML
    private void handleSendNotificationButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/SendNotification");
    }

    @FXML
    private void handleRevenueChartButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/RevenueChart");
    }

    @FXML
    private void handleReactivateUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/ReactivateUser");
    }

    @FXML
    private void handleDeleteUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/DeleteUser");
    }



    @FXML
    private void logoutButtonOnClick(ActionEvent event) {

        try {
            SceneSwitcher.switchTo("loginScene");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
