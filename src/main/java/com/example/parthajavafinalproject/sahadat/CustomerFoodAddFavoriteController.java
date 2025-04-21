package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerFoodAddFavoriteController {
    @javafx.fxml.FXML
    private ListView<String> listV; // use generics

    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void pizzaButton(ActionEvent actionEvent) {
        listV.getItems().add("Pizza");
    }

    @javafx.fxml.FXML
    public void tacosButton(ActionEvent actionEvent) {
        listV.getItems().add("Tacos");
    }

    @javafx.fxml.FXML
    public void sushiButton(ActionEvent actionEvent) {
        listV.getItems().add("Sushi");
    }

    @javafx.fxml.FXML
    public void burgerButton(ActionEvent actionEvent) {
        listV.getItems().add("Burger");
    }

    @javafx.fxml.FXML
    public void viewButton(ActionEvent actionEvent) {
        label.setText("Confirmed Favorite");
    }

    @javafx.fxml.FXML
    public void customerDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sahadat/customerDashboard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }
}
