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

public class WaiterModifiesOrderScenecontroller {

    @javafx.fxml.FXML
    private TableColumn<Order, String> tableNoCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderDetailsCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> phoneNumberCol;
    @javafx.fxml.FXML
    private TableView<Order> tableView;
    @javafx.fxml.FXML
    private TextField phoneSearchTextField;
    @javafx.fxml.FXML
    private TextArea textAreaModify;
    @javafx.fxml.FXML
    private Label label;

    private List<Order> orderList = new ArrayList<>();
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> orderStatusComboBox;


    @javafx.fxml.FXML
    public void initialize() {
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tableNoCol.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
        orderDetailsCol.setCellValueFactory(new PropertyValueFactory<>("orderDetails"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));

        orderStatusComboBox.getItems().addAll("Pending", "BeingPrepared", "Ready", "Canceled", "Modified");
        loadArrayListFromFile();
        tableView.getItems().setAll(orderList);  // populate the table with the loaded orders
    }


    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String searchPhoneNumber = phoneSearchTextField.getText().trim();

        // Search for the order by phone number
        for (Order order : orderList) {
            if (order.getPhoneNumber().equals(searchPhoneNumber)) {
                textAreaModify.setText(order.getOrderDetails());  // Display current order details in TextArea
                label.setText("Order found! Modify the details.");
                return;
            }
        }

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
            stage.setTitle("waiterDashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }

    }

    private void loadArrayListFromFile() {
        File f = new File("Order.bin");
        if (f.exists()) {
            try (FileInputStream fis = new FileInputStream(f);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (true) {
                    try {
                        Order o = (Order) ois.readObject();
                        orderList.add(o);
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
                oos.writeObject(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void modifyOrderDetailsButtonOnAction(ActionEvent actionEvent) {
        String searchPhoneNumber = phoneSearchTextField.getText().trim();
        String newOrderDetails = textAreaModify.getText().trim();
        String newOrderStatus = orderStatusComboBox.getValue();

        if (newOrderDetails.isEmpty()) {
            label.setText("Please enter valid order details to modify.");
            return;
        }

        if (newOrderStatus == null || newOrderStatus.isEmpty()) {
            label.setText("Please select a new order status.");
            return;
        }

        // Search and update
        for (Order order : orderList) {
            if (order.getPhoneNumber().equals(searchPhoneNumber)) {
                order.orderDetails = newOrderDetails; // Update order details
                order.orderStatus = newOrderStatus;   // Update order status

                label.setText("Order details and status updated successfully!");

                tableView.refresh(); // Refresh table
                saveOrdersToFile();  // Save changes
                return;
            }
        }

        label.setText("Order not found for this phone number.");

    }
}