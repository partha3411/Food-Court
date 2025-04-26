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
    private Label successLabel;


    private static final File userFile = new File("createUsers.dat");

    @FXML
    public void initialize() {

        roleComboBox.getItems().addAll("Admin", "User", "Manager");
    }

    @FXML
    private void handleSubmitButton(ActionEvent event) {

        String userId = userIdField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String email = emailField.getText();
        String role = roleComboBox.getValue();
        String salaryText = salaryField.getText();

        if (userId.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || role == null || salaryText.isEmpty()) {
            successLabel.setText("All fields must be filled!");
            successLabel.setVisible(true);
            return;
        }


        if (!password.equals(confirmPassword)) {
            successLabel.setText("Passwords do not match!");
            successLabel.setVisible(true);
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            successLabel.setText("Salary must be a valid number!");
            successLabel.setVisible(true);
            return;
        }


        CreateUser user = new CreateUser(userId, name, password, email, role, salary);


        BinaryFileHelper.saveObject(userFile, user);


        successLabel.setText("User created successfully!");
        successLabel.setVisible(true);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            SceneSwitcher.switchTo("sabbir/AdminDashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
