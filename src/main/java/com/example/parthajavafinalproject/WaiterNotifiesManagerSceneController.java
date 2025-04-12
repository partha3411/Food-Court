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

import java.io.*;
import java.util.ArrayList;

public class WaiterNotifiesManagerSceneController {

    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private Label label;

    private ArrayList<Notice> newNoticeArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        // No file loading needed
    }

    @javafx.fxml.FXML
    public void sendButtonOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText().trim();
        String message = textArea.getText().trim();

        if (name.isEmpty() || message.isEmpty()) {
            label.setText("Please enter both name and message.");
            return;
        }

        Notice newNotice = new Notice(name, message);
        newNoticeArrayList.add(newNotice);
        saveNoticesToFile();

        label.setText("Notice sent to manager.");

        // Clear inputs
        nameTextField.clear();
        textArea.clear();
    }

    private void saveNoticesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("noticeToManager.bin"))) {
            oos.writeObject(newNoticeArrayList);
        } catch (IOException e) {
            e.printStackTrace();
            label.setText("Failed to send notice.");
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
