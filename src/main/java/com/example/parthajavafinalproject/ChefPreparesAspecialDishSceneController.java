package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChefPreparesAspecialDishSceneController {

    @javafx.fxml.FXML
    private TableView<SpecialDishRequest> tableView;
    @javafx.fxml.FXML
    private TableColumn<SpecialDishRequest, String> orderDetailsCol;
    @javafx.fxml.FXML
    private TableColumn<SpecialDishRequest, String> statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TableColumn<SpecialDishRequest, String> phoneNumberCol;

    private List<SpecialDishRequest> specialDishRequestList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize the columns to display data
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        orderDetailsCol.setCellValueFactory(new PropertyValueFactory<>("requestDetails"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Populate ComboBox with possible statuses
        statusComboBox.getItems().addAll("Pending", "In Progress", "Ready");

        // Load and show special dish requests
        loadSpecialDishRequestsFromFile();
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        String phone = phoneNumberTextField.getText().trim();
        String status = statusComboBox.getValue();

        if (phone.isEmpty() || status == null) {
            showAlert("Invalid Input", "Please enter a phone number and select a status.");
            return;
        }

        // Update the status
        for (SpecialDishRequest request : specialDishRequestList) {
            if (request.getPhoneNumber().equals(phone)) {
                request.setStatus(status);
                break;
            }
        }

        // Save and refresh
        saveSpecialDishRequestsToFile();
        tableView.refresh();
    }

    private void loadSpecialDishRequestsFromFile() {
        specialDishRequestList.clear();
        File file = new File("specialDishRequest.bin");

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                while (true) {
                    try {
                        SpecialDishRequest request = (SpecialDishRequest) ois.readObject();
                        specialDishRequestList.add(request);
                    } catch (EOFException eof) {
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Show on table
        tableView.getItems().setAll(specialDishRequestList);
    }

    private void saveSpecialDishRequestsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("specialDishRequest.bin"))) {
            for (SpecialDishRequest request : specialDishRequestList) {
                oos.writeObject(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefDashboardScene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Chef Dashboard");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
