package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerFoodAddFavoriteController {
    @javafx.fxml.FXML
    private Label label4;
    @javafx.fxml.FXML
    private Label label5;
    @javafx.fxml.FXML
    private Label label6;
    @javafx.fxml.FXML
    private Label label1;
    @javafx.fxml.FXML
    private Label label2;
    @javafx.fxml.FXML
    private Label label3;

    @javafx.fxml.FXML
    public void pizzaButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void tacosButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void viewFavoritesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sushiButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void burgerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerDashboard(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sahadat/customerDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }
}
