package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ChefEnsuresKitchenInventoryIsEnoughSceneController {

    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextArea textArea;

    private ArrayList<InventoryNotice> noticeList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        loadInventoryNotices(); // load existing notices if any
    }

    private void loadInventoryNotices() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inventory_notices.bin"))) {
            noticeList = (ArrayList<InventoryNotice>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // File might not exist yet – that’s okay
        }
    }

    private void saveInventoryNotices() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory_notices.bin"))) {
            for (InventoryNotice notice : noticeList) {
                oos.writeObject(notice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void sendToManagerButtonOnAction(ActionEvent actionEvent) {
        String message = textArea.getText().trim();

        if (message.isEmpty()) {
            label.setText("Message cannot be empty.");
            return;
        }

        InventoryNotice newNotice = new InventoryNotice(message);
        noticeList.add(newNotice);
        saveInventoryNotices();

        label.setText("Message sent to manager.");
        textArea.clear();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefDashboardScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Chef Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
