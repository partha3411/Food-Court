package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ChefRecievesNotificationsScenecontroller {

    @FXML
    private TableColumn<Notice, String> messageCol;

    @FXML
    private TableView<Notice> tableView;

    @FXML
    private TableColumn<Notice, String> waiterNameCol;

    @FXML
    public void initialize() {
        waiterNameCol.setCellValueFactory(new PropertyValueFactory<>("waiterName"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
    }

    @FXML
    public void loadNotificationButton(ActionEvent actionEvent) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("notices.bin"))) {
            // Read the entire ArrayList<Notice>
            ArrayList<Notice> noticeList = (ArrayList<Notice>) ois.readObject();
            tableView.getItems().setAll(noticeList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
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
