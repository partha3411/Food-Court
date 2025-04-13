package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WaiterSendsCustomerCriticToChefSceneController {
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField tableNoTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextArea textArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendButtonOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText().trim();
        String phone = phoneNumberTextField.getText().trim();
        String tableNo = tableNoTextField.getText().trim();
        String critic = textArea.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || tableNo.isEmpty() || critic.isEmpty()) {
            label.setText("Please fill in all fields.");
            return;
        }

        CustomerCritic customerCritic = new CustomerCritic(name, phone, tableNo, critic);

        try (FileOutputStream fos = new FileOutputStream("customerCritic.bin", true);
             ObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {
            oos.writeObject(customerCritic);
            label.setText("Critic sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            label.setText("Failed to send critic.");
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
