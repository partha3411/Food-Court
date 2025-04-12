package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class WaiterViewsSpecificCustomerOrderSceneController {

    @javafx.fxml.FXML
    private TableColumn<Order, String> orderdetailsCol;
    @javafx.fxml.FXML
    private TextField phoneNumbertextField;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> phonenumberCol;
    @javafx.fxml.FXML
    private TableView<Order> tableView;

    private ArrayList<Order> orderArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        orderdetailsCol.setCellValueFactory(new PropertyValueFactory<>("orderDetails"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        phonenumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        loadOrdersFromFile();
    }

    private void loadOrdersFromFile() {
        orderArrayList.clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Order.bin"))) {
            while (true) {
                try {
                    Order o = (Order) ois.readObject();
                    orderArrayList.add(o);
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String phone = phoneNumbertextField.getText().trim();
        ArrayList<Order> filtered = new ArrayList<>();

        for (Order o : orderArrayList) {
            if (o.getPhoneNumber().equals(phone)) {
                filtered.add(o);
            }
        }

        tableView.getItems().setAll(filtered);
    }

    @javafx.fxml.FXML
    public void backButtonOnaction(ActionEvent actionEvent) {
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
