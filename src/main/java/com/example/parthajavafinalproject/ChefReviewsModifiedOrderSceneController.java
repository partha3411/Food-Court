package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ChefReviewsModifiedOrderSceneController {

    @FXML
    private TableColumn<Order, String> orderDetailsCol;
    @FXML
    private TableColumn<Order, String> statusCol;
    @FXML
    private TableColumn<Order, String> phoneNumberCol;
    @FXML
    private TableView<Order> tableView;

    private ArrayList<Order> allOrders = new ArrayList<>();

    @FXML
    public void initialize() {
        orderDetailsCol.setCellValueFactory(new PropertyValueFactory<>("orderDetails"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        loadOrdersFromFile();
        tableView.getItems().setAll(allOrders);
    }

    private void loadOrdersFromFile() {
        allOrders.clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Order.bin"))) {
            while (true) {
                try {
                    Order order = (Order) ois.readObject();
                    allOrders.add(order);
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void FilteronlymodifiedordersButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        for (Order order : allOrders) {
            if ("Modified".equalsIgnoreCase(order.getOrderStatus())) {
                tableView.getItems().add(order);
            }
        }
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefDashboardScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Chef Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
