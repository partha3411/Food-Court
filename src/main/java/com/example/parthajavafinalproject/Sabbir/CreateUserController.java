package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateUserController {

    @FXML private Button submitButton;
    @FXML private TextField userIdField;
    @FXML private ComboBox<String> roleComboBox;
    @FXML private TextField nameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField emailField;
    @FXML private TextField salaryField;
    @FXML private PasswordField confirmPasswordField;

    @FXML
    public void initialize() {
        roleComboBox.getItems().addAll("ProductSupplier", "Supplier", "Staff");

        submitButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            public void handle(javafx.event.ActionEvent event) {
                String userId = userIdField.getText();
                String name = nameField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                String email = emailField.getText();
                String role = roleComboBox.getValue();
                String salary = salaryField.getText();

                if (userId.isEmpty()) {
                    showMessage("User ID is required.");
                    return;
                }
                if (name.isEmpty()) {
                    showMessage("Name is required.");
                    return;
                }
                if (password.isEmpty()) {
                    showMessage("Password is required.");
                    return;
                }
                if (confirmPassword.isEmpty()) {
                    showMessage("Confirm Password is required.");
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    showMessage("Passwords do not match.");
                    return;
                }
                if (email.isEmpty()) {
                    showMessage("Email is required.");
                    return;
                }
                if (role == null) {
                    showMessage("Please select a role.");
                    return;
                }
                if (salary.isEmpty()) {
                    showMessage("Salary is required.");
                    return;
                }

                showMessage("User created successfully!");
                System.out.println("User ID: " + userId);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Role: " + role);
                System.out.println("Salary: " + salary);
            }
        });
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
