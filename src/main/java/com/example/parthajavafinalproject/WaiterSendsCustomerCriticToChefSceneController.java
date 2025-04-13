package com.example.parthajavafinalproject;

import com.example.parthajavafinalproject.CustomerCritic;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
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

        saveCustomerCriticToFile(customerCritic);
    }

    private void saveCustomerCriticToFile(CustomerCritic customerCritic) {
        try {
            File f = new File("customerCritic.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(customerCritic);
            oos.close();
            fos.close();

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
