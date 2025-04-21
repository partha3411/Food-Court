package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private void handleCreateUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/CreateUser");  // Switch to CreateUser.fxml
    }

    @FXML
    private void handleUserActivityButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/UserActivity");  // Switch to UserActivity.fxml
    }

    @FXML
    private void handleSalesReportButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/SalesReport");  // Switch to SalesReport.fxml
    }

    @FXML
    private void handleUpdateUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/UpdateUser");  // Switch to UpdateUser.fxml
    }

    @FXML
    private void handleLogOutButton(ActionEvent event) {
        // Implement LogOut functionality
        System.out.println("Logging out...");
        // Additional log-out logic, like closing the stage or navigating to a login screen.
    }

    @FXML
    private void handleSendNotificationButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/SendNotification");  // Switch to SendNotification.fxml
    }

    @FXML
    private void handleRevenueChartButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/RevenueChart");  // Switch to RevenueChart.fxml
    }

    @FXML
    private void handleReactivateUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/ReactivateUser");  // Switch to ReactivateUser.fxml
    }

    @FXML
    private void handleDeleteUserButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("sabbir/DeleteUser");  // Switch to DeleteUser.fxml
    }



    @FXML
    private void logoutButtonOnClick(ActionEvent event) {
        // Switch back to the Admin Dashboard when the Back button is clicked
        try {
            SceneSwitcher.switchTo("loginScene");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
