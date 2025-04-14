package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ChefViewsSpecificCustomerOrderSceneController {
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderdetailsCol;
    @javafx.fxml.FXML
    private TextField phoneNumbertextField;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> phoneNumberCol;
    @javafx.fxml.FXML
    private TableView<Order> tableView;
    @javafx.fxml.FXML
    private TextField tableNumberTextField;

    private final ArrayList<Order> orderList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        orderdetailsCol.setCellValueFactory(new PropertyValueFactory<>("orderDetails"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
    }

    @javafx.fxml.FXML
    public void backButtononAction(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String phoneInput = phoneNumbertextField.getText().trim();
        String tableInput = tableNumberTextField.getText().trim();

        loadOrdersFromFile(); // Load all orders into orderList

        ArrayList<Order> filteredOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getPhoneNumber().equals(phoneInput) || order.getTableNumber().equals(tableInput)) {
                filteredOrders.add(order);
            }
        }

        tableView.getItems().setAll(filteredOrders);
    }

    private void loadOrdersFromFile() {
        orderList.clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Order.bin"))) {
            while (true) {
                try {
                    Order order = (Order) ois.readObject();
                    orderList.add(order);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
