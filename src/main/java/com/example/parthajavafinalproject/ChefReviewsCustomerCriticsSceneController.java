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

    private ArrayList<CustomerCritic> customerCriticArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        phonenumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        criticsCol.setCellValueFactory(new PropertyValueFactory<>("criticMessage"));
    }

    private void loadCustomerCriticsFromFile() {
        customerCriticArrayList.clear();
        File file = new File("customerCritic.bin");

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                // Read objects one by one from the file
                while (true) {
                    try {
                        CustomerCritic critic = (CustomerCritic) ois.readObject();
                        customerCriticArrayList.add(critic);
                    } catch (EOFException e) {
                        // End of file reached, exit the loop
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        tableView.getItems().setAll(customerCriticArrayList);
    }

    @javafx.fxml.FXML
    public void loadButtonOnAction(ActionEvent actionEvent) {
        loadCustomerCriticsFromFile();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefDashboardScene.fxml"));
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
