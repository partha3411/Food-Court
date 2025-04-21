package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.BinaryFileHelper;
import com.example.parthajavafinalproject.Sabbir.CreateUser;
import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class CreateUserController {

    @FXML
    private TextField userIdField;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField emailField;
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private TextField salaryField;

    @FXML
    private Label successLabel; // Label for success message

    // File where user data will be saved
    private static final File userFile = new File("createUsers.dat");

    @FXML
    public void initialize() {
        // Initialize the role ComboBox with roles
        roleComboBox.getItems().addAll("Admin", "User", "Manager"); // Example roles
    }

    @FXML
    private void handleSubmitButton(ActionEvent event) {
        // Collect data from the fields
        String userId = userIdField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String email = emailField.getText();
        String role = roleComboBox.getValue();
        String salaryText = salaryField.getText();

        // Validate empty fields
        if (userId.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || role == null || salaryText.isEmpty()) {
            successLabel.setText("All fields must be filled!");
            successLabel.setVisible(true);
            return;
        }

        // Validate password match
        if (!password.equals(confirmPassword)) {
            successLabel.setText("Passwords do not match!");
            successLabel.setVisible(true);
            return;
        }

        // Validate salary input (ensure it's a valid double)
        double salary;
        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            successLabel.setText("Salary must be a valid number!");
            successLabel.setVisible(true);
            return;
        }

        // Create a CreateUser object
        CreateUser user = new CreateUser(userId, name, password, email, role, salary);

        // Save the user object to the binary file
        BinaryFileHelper.saveObject(userFile, user);

        // Display success message
        successLabel.setText("User created successfully!");
        successLabel.setVisible(true);

        // After a brief delay, navigate back to Admin Dashboard
        try {
            Thread.sleep(2000); // Delay for 2 seconds before switching scenes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        // Switch back to the Admin Dashboard when the Back button is clicked
        try {
            SceneSwitcher.switchTo("sabbir/AdminDashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
