package sahadat2221634;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

import java.util.*;

public class OrderController {

    @FXML
    private ComboBox<Restaurant> restaurantComboBox;

    @FXML
    private ListView<FoodItem> menuListView;

    @FXML
    private Button confirmButton;

    @FXML
    private Label statusLabel;

    private ObservableList<Restaurant> restaurants;

    @FXML
    public void initialize() {
        loadRestaurants();
        restaurantComboBox.setItems(restaurants);

        restaurantComboBox.setOnAction(e -> {
            Restaurant selected = restaurantComboBox.getSelectionModel().getSelectedItem();
            if (selected != null) {
                menuListView.setItems(FXCollections.observableArrayList(selected.getMenu()));
            }
        });
    }

    @FXML
    private void handleConfirmOrder() {
        FoodItem selectedItem = menuListView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            statusLabel.setText("Please select a food item.");
        } else if (!selectedItem.isAvailable()) {
            statusLabel.setText("Sorry, this item is not available.");
        } else {
            boolean paymentSuccess = verifyPayment(selectedItem.getPrice());
            if (paymentSuccess) {
                statusLabel.setText("Order confirmed! Thank you for your purchase.");
            } else {
                statusLabel.setText("Payment failed. Please try again.");
            }
        }
    }

    private boolean verifyPayment(double amount) {
        // Mock payment logic
        return true; // Assume payment is always successful
    }

    private void loadRestaurants() {
        FoodItem burger = new FoodItem("Burger", 5.99, true);
        FoodItem pizza = new FoodItem("Pizza", 8.99, false);
        FoodItem sushi = new FoodItem("Sushi", 12.50, true);

        Restaurant r1 = new Restaurant("Food Palace", Arrays.asList(burger, pizza));
        Restaurant r2 = new Restaurant("Sushi World", Arrays.asList(sushi));

        restaurants = FXCollections.observableArrayList(r1, r2);
    }
}
