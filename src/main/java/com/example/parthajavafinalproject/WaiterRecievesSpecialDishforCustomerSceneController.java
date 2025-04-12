package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendButtononAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String phone = phoneNumberTextFiled.getText();
        String table = tableNumbertextField.getText();
        String details = textArea.getText();

        if (name.isEmpty() || phone.isEmpty() || table.isEmpty() || details.isEmpty()) {
            label.setText("Please fill in all fields.");
            return;
        }

        SpecialDishRequest request = new SpecialDishRequest(name, phone, table, details);

        try (FileOutputStream fos = new FileOutputStream("specialDishRequest.bin", true);
             ObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {
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
