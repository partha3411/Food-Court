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

public class WaiterTracksOrderStatuscontroller {

    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> phonenumberCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> nameCol;
    @javafx.fxml.FXML
    private TableView<Order> tableView;

    private ArrayList<Order> orderList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phonenumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));

        loadOrdersFromFile();
    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String searchPhone = phoneNumberTextField.getText().trim();

        if (searchPhone.isEmpty()) {
            showAlert("Please enter a phone number to search.");
            return;
        }

        ArrayList<Order> matchedOrders = new ArrayList<>();

        for (Order order : orderList) {
            if (order.getPhoneNumber().equals(searchPhone)) {
                matchedOrders.add(order);
            }
        }

        if (matchedOrders.isEmpty()) {
            showAlert("No order found for the entered phone number.");
        } else {
            tableView.getItems().setAll(matchedOrders);
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

    private void loadOrdersFromFile() {
        File file = new File("Order.bin");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                orderList.clear();
                while (true) {
                    try {
                        Order order = (Order) ois.readObject();
                        orderList.add(order);
                    } catch (EOFException e) {
                        break; // End of file
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
