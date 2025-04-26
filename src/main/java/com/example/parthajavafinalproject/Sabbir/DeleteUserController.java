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


    private static final File userFile = new File("createUsers.dat");

    @FXML
    public void initialize() {

        loadUsers();
    }


    private void loadUsers() {
        List<CreateUser> users = BinaryFileHelper.readAllObjects(userFile);


        userComboBox.getItems().clear();


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


        List<CreateUser> users = BinaryFileHelper.readAllObjects(userFile);


        CreateUser userToDelete = null;
        for (CreateUser user : users) {
            if (user.getName().equals(selectedUserName)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {

            users.remove(userToDelete);


            BinaryFileHelper.writeAllObjects(userFile, users);

            successLabel.setText("User " + selectedUserName + " deleted successfully!");
            successLabel.setVisible(true);


            loadUsers();
        } else {
            successLabel.setText("User not found.");
            successLabel.setVisible(true);
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
