package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerOrderController implements Initializable {

    @FXML
    private ComboBox<String> foodComboBox;

    @FXML
    private ComboBox<String> restaurantsCB;

    @FXML
    private ListView<String> menuListView;

    @FXML
    private Label Label3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populate food items
        foodComboBox.getItems().addAll(
                "Burger", "Pizza", "Pasta", "Sushi", "Fried Rice"
        );

        // Populate restaurant names
        restaurantsCB.getItems().addAll(
                "Food Palace", "Spicy Bite", "Ocean Dine", "Green Garden", "Taco Town"
        );
    }

    @FXML
    private void foodButton(ActionEvent event) {
        String selectedFood = foodComboBox.getValue();
        if (selectedFood != null && !menuListView.getItems().contains(selectedFood)) {
            menuListView.getItems().add(selectedFood);
        }
    }

    @FXML
    private void restaurantButton(ActionEvent event) {
        String selectedRestaurant = restaurantsCB.getValue();
        System.out.println("Selected restaurant: " + selectedRestaurant);


        menuListView.getItems().clear(); // Clear previous items
        if (selectedRestaurant != null) {
            if (selectedRestaurant.equals("Food Palace")) {
                menuListView.getItems().addAll("Burger", "Pizza", "Pasta");
            } else if (selectedRestaurant.equals("Spicy Bite")) {
                menuListView.getItems().addAll("Fried Rice", "Pizza");
            }

        }
    }

    @FXML
    private void handelConfirmOrder(ActionEvent event) {
        Label3.setText("Order Confirmed!");
    }

    @FXML
    private void customerDashboard(ActionEvent event) throws IOException {
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
