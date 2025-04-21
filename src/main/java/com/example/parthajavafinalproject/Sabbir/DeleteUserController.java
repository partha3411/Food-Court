package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.BinaryFileHelper;
import com.example.parthajavafinalproject.Sabbir.CreateUser;
import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DeleteUserController {

    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private Button deleteButton;
    @FXML
    private Button backButton;
    @FXML
    private Label successLabel;

    // File where users are stored
    private static final File userFile = new File("createUsers.dat");

    @FXML
    public void initialize() {
        // Load users and populate ComboBox
        loadUsers();
    }

    // Load users into ComboBox
    private void loadUsers() {
        List<CreateUser> users = BinaryFileHelper.readAllObjects(userFile);

        // Clear the ComboBox to avoid duplication
        userComboBox.getItems().clear();

        // Add the user names to the ComboBox
        for (CreateUser user : users) {
            userComboBox.getItems().add(user.getName());
        }
    }

    @FXML
    private void handleDeleteButton(ActionEvent event) {
        String selectedUserName = userComboBox.getValue();

        if (selectedUserName == null) {
            System.out.println("No user selected.");
            return;
        }

        // Read all users from the file
        List<CreateUser> users = BinaryFileHelper.readAllObjects(userFile);

        // Find the user to delete
        CreateUser userToDelete = null;
        for (CreateUser user : users) {
            if (user.getName().equals(selectedUserName)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            // Remove the user from the list
            users.remove(userToDelete);

            // Write the updated list of users back to the file
            BinaryFileHelper.writeAllObjects(userFile, users);

            // Show success message
            successLabel.setText("User " + selectedUserName + " deleted successfully!");
            successLabel.setVisible(true);

            // Reload the ComboBox after deletion
            loadUsers();
        } else {
            successLabel.setText("User not found.");
            successLabel.setVisible(true);
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        // Switch back to the Admin Dashboard
        try {
            SceneSwitcher.switchTo("sabbir/AdminDashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
