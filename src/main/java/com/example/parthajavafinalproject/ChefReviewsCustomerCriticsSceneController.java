package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
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

public class ChefReviewsCustomerCriticsSceneController {
    @javafx.fxml.FXML
    private TableColumn<CustomerCritic, String> criticsCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerCritic, String> phonenumberCol;
    @javafx.fxml.FXML
    private TableView<CustomerCritic> tableView;

    private ArrayList<CustomerCritic> criticList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        phonenumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        criticsCol.setCellValueFactory(new PropertyValueFactory<>("critic"));
    }

    @javafx.fxml.FXML
    public void loadButtonOnAction(ActionEvent actionEvent) {
        criticList.clear();
        File file = new File("customerCritics.bin");

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    try {
                        CustomerCritic c = (CustomerCritic) ois.readObject();
                        criticList.add(c);
                    } catch (EOFException eof) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        tableView.getItems().setAll(criticList);
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
