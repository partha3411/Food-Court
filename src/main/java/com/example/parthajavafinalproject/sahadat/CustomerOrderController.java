package com.example.parthajavafinalproject.sahadat;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CustomerOrderController {

    @FXML
    private ComboBox<String> restaurantComboBox;

    @FXML
    private ListView<String> menuListView;

    @FXML
    private Label statusLabel;
    @FXML
    private Label statusLabel1;
    @FXML
    private Label statusLabel2;
    @FXML
    private Label statusLabel3;


    private final ObservableList<String> pizzaMenu = FXCollections.observableArrayList("Pepperoni", "Cheese", "Veggie");
    private final ObservableList<String> burgerMenu = FXCollections.observableArrayList("Beef Burger", "Chicken Burger", "Veggie Burger");
    private final ObservableList<String> sushiMenu = FXCollections.observableArrayList("California Roll", "Tuna Roll", "Salmon");
    @FXML
    private ChoiceBox restaurantsCB;

    @FXML
    public void initialize() {
        // Load restaurant names
        restaurantComboBox.setItems(FXCollections.observableArrayList("Pizza Palace", "Burger Barn", "Sushi Spot"));

        // When a restaurant is selected, update the menu
        restaurantComboBox.setOnAction(e -> {
            String selected = restaurantComboBox.getValue();
            if (selected == null) return;

            switch (selected) {
                case "Pizza Palace":
                    menuListView.setItems(pizzaMenu);
                    break;
                case "Burger Barn":
                    menuListView.setItems(burgerMenu);
                    break;
                case "Sushi Spot":
                    menuListView.setItems(sushiMenu);
                    break;
                default:
                    menuListView.getItems().clear();
            }

            statusLabel3.setText("");
        });
    }

    @FXML
    private void handelConfirmOrder() {
        String restaurant = restaurantComboBox.getValue();
        String foodItem = menuListView.getSelectionModel().getSelectedItem();

        if (restaurant == null) {
            statusLabel3.setText("Please select a restaurant.");
        } else if (foodItem == null) {
            statusLabel3.setText("Please select a food item.");
        } else {
            // Simulate food availability and payment
            boolean available = true;
            boolean payment = true;

            if (!available) {
                statusLabel3.setText(" Item not available.");
            } else if (!payment) {
                statusLabel3.setText("Payment failed.");
            } else {
                statusLabel3.setText("Order confirmed!");
            }
        }
    }
}


