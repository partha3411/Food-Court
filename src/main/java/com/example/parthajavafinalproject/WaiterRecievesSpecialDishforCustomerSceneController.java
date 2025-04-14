package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.*;

public class WaiterRecievesSpecialDishforCustomerSceneController {
    @javafx.fxml.FXML
    private TextField tableNumbertextField;
    @javafx.fxml.FXML
    private TextField phoneNumberTextFiled;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;  // ComboBox for status

    @javafx.fxml.FXML
    public void initialize() {
        // Populate the ComboBox with possible statuses
        statusComboBox.getItems().addAll("Pending", "Being Prepared", "Ready");
    }

    @javafx.fxml.FXML
    public void sendButtononAction(ActionEvent actionEvent) {
        String name = nameTextField.getText().trim();
        String phone = phoneNumberTextFiled.getText().trim();
        String table = tableNumbertextField.getText().trim();
        String requestDetails = textArea.getText().trim();
        String status = statusComboBox.getValue();  // Get the selected status from ComboBox

        if (name.isEmpty() || phone.isEmpty() || table.isEmpty() || requestDetails.isEmpty() || status == null) {
            label.setText("Please fill in all fields and select a status.");
            return;
        }

        SpecialDishRequest request = new SpecialDishRequest(name, phone, table, requestDetails, status);

        saveSpecialDishRequestToFile(request);
    }

    private void saveSpecialDishRequestToFile(SpecialDishRequest request) {
        File file = new File("specialDishRequest.bin");
        boolean append = file.exists();

        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = append
                     ? new AppendableObjectOutputStream(fos)
                     : new ObjectOutputStream(fos)) {

            oos.writeObject(request);
            label.setText("Special dish request sent successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            label.setText("Error saving the request.");
        }
    }


    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("waiterDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Waiter Dashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
