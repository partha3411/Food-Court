package com.example.parthajavafinalproject.Sabbir;

import com.example.parthajavafinalproject.BinaryFileHelper;
import com.example.parthajavafinalproject.Sabbir.CreateUser;
import com.example.parthajavafinalproject.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpdateUserController {

    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField roleField;
    @FXML
    private Button updateButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView<CreateUser> userTableView;
    @FXML
    private TableColumn<CreateUser, String> userIdColumn;
    @FXML
    private TableColumn<CreateUser, String> nameColumn;
    @FXML
    private TableColumn<CreateUser, String> passwordColumn;
    @FXML
    private TableColumn<CreateUser, String> emailColumn;
    @FXML
    private TableColumn<CreateUser, String> roleColumn;
    @FXML
    private TableColumn<CreateUser, Double> salaryColumn;
    @FXML
    private Label successLabel;


    private static final File userFile = new File("createUsers.dat");

    @FXML
    public void initialize() {

        loadUsers();
        initializeTable();
    }


    private void loadUsers() {
        List<CreateUser> users = BinaryFileHelper.readAllObjects(userFile);


        userComboBox.getItems().clear();


        for (CreateUser user : users) {
            userComboBox.getItems().add(user.getUserId());
        }


        userTableView.getItems().setAll(users);
    }


    private void initializeTable() {
        userIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserId()));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        passwordColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassword()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        roleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRole()));
        salaryColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSalary()).asObject());
    }


    @FXML
    private void handleUserSelection() {
        String selectedUserId = userComboBox.getValue();

        if (selectedUserId == null) {
            return;
        }


        List<CreateUser> users = BinaryFileHelper.readAllObjects(userFile);
        for (CreateUser user : users) {
            if (user.getUserId().equals(selectedUserId)) {
                nameField.setText(user.getName());
                emailField.setText(user.getEmail());
                salaryField.setText(String.valueOf(user.getSalary()));
                roleField.setText(user.getRole());
                break;
            }
        }
    }

    @FXML
    private void handleUpdateButton(ActionEvent event) {
        String selectedUserId = userComboBox.getValue();

        if (selectedUserId == null) {
            successLabel.setText("No user selected.");
            successLabel.setVisible(true);
            return;
        }


        List<CreateUser> users = BinaryFileHelper.readAllObjects(userFile);
        CreateUser userToUpdate = null;
        for (CreateUser user : users) {
            if (user.getUserId().equals(selectedUserId)) {
                userToUpdate = user;
                break;
            }
        }

        if (userToUpdate != null) {

            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || salaryField.getText().isEmpty() || roleField.getText().isEmpty()) {
                successLabel.setText("All fields must be filled!");
                successLabel.setVisible(true);
                return;
            }


            userToUpdate.setName(nameField.getText());
            userToUpdate.setEmail(emailField.getText());

            double salary;
            try {
                salary = Double.parseDouble(salaryField.getText());
                userToUpdate.setSalary(salary);
            } catch (NumberFormatException e) {
                successLabel.setText("Salary must be a valid number!");
                successLabel.setVisible(true);
                return;
            }

            userToUpdate.setRole(roleField.getText());


            BinaryFileHelper.writeAllObjects(userFile, users);


            loadUsers();
            successLabel.setText("User updated successfully!");
            successLabel.setVisible(true);

            nameField.clear();
            emailField.clear();
            salaryField.clear();
            roleField.clear();
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
