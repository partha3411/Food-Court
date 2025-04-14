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

public class WaiterCancelsanOrderScenecontroller {

    @javafx.fxml.FXML
    private TextField phoneNumberseacrhTextField;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> phoneNumberCol;
    @javafx.fxml.FXML
    private TableView<Order> tableView;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private ComboBox<String> orderStatusComboBox;

    private ArrayList<Order> orderList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        // Add possible statuses to the ComboBox
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        orderStatusComboBox.getItems().addAll("Pending", "BeingPrepared", "Ready", "Canceled");

        // Load orders from file and populate TableView
        loadArrayListFromFile();
        tableView.getItems().setAll(orderList);
    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String searchPhoneNumber = phoneNumberseacrhTextField.getText().trim();

        // Search for the order by phone number
        for (Order order : orderList) {
            if (order.getPhoneNumber().equals(searchPhoneNumber)) {
                // If order found, show the current status in the ComboBox
                orderStatusComboBox.setValue(order.getOrderStatus());
                label.setText("Order found! Modify the status.");
                return;
            }
        }

        // If no matching phone number is found
        label.setText("Order not found for this phone number.");
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("waiterDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Waiter Dashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }
    }

    @javafx.fxml.FXML
    public void loadOrderButtonOnAction(ActionEvent actionEvent) {
        // Load orders and update TableView
        loadArrayListFromFile();
        tableView.getItems().setAll(orderList);  // Populate the table with the loaded orders
    }

    @javafx.fxml.FXML
    public void saveStatusButtonOnAction(ActionEvent actionEvent) {
        String searchPhoneNumber = phoneNumberseacrhTextField.getText().trim();
        String newStatus = orderStatusComboBox.getValue();

        if (newStatus == null) {
            label.setText("Please select a valid status.");
            return;
        }

        // Search for the order by phone number and update the status
        for (Order order : orderList) {
            if (order.getPhoneNumber().equals(searchPhoneNumber)) {
                // Update the order's status
                order.setOrderStatus(newStatus);
                label.setText("Order status updated successfully!");

                // Update the TableView
                tableView.refresh();

                // Save the updated orders to file
                saveOrdersToFile();
                return;
            }
        }

        // If no matching phone number is found
        label.setText("Order not found for this phone number.");
    }

    private void loadArrayListFromFile() {
        File file = new File("Order.bin");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                orderList.clear(); // Clear existing list before loading new data
                while (true) {
                    try {
                        Order order = (Order) ois.readObject();
                        orderList.add(order);
                    } catch (Exception e) {
                        break; // End of file or invalid object
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveOrdersToFile() {
        try (FileOutputStream fos = new FileOutputStream("Order.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Order order : orderList) {
                oos.writeObject(order); // Write each order to the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
