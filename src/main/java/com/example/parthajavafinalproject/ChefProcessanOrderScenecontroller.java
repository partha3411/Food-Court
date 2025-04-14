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

public class ChefProcessanOrderScenecontroller {

    @javafx.fxml.FXML
    private TableView<Order> tableView;
    @javafx.fxml.FXML
    private TableColumn<Order, String> phoneNumberCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderdetailsCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField phoneNumbertextField;

    private List<Order> orderList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        orderdetailsCol.setCellValueFactory(new PropertyValueFactory<>("orderDetails"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));

        statusComboBox.getItems().addAll("Pending", "BeingPrepared", "Ready", "Canceled");

        loadOrdersFromFile();
        tableView.getItems().setAll(orderList);
    }

    @javafx.fxml.FXML
    public void updateButtononAction(ActionEvent actionEvent) {
        String phone = phoneNumbertextField.getText();
        String status = statusComboBox.getValue();

        for (Order order : orderList) {
            if (order.getPhoneNumber().equals(phone)) {
                order.setOrderStatus(status);
                break;
            }
        }

        saveOrdersToFile();
        tableView.refresh();
    }

    private void loadOrdersFromFile() {
        orderList.clear();
        File file = new File("Order.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    try {
                        Order order = (Order) ois.readObject();
                        orderList.add(order);
                    } catch (EOFException eof) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveOrdersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Order.bin"))) {
            for (Order order : orderList) {
                oos.writeObject(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefDashboardScene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Chef Dashboard");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
