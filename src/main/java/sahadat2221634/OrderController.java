package sahadat2221634;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.Label;

public class OrderController {

    @FXML
    private ListView<FoodItem> menuListView;
    private Label statusLabel;

    public OrderController(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    @FXML
    public void initialize() {
        // You can fill this based on your logic
        System.out.println("FXML UI loaded successfully");
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
                statusLabel.setText("Order confirmed!");
            } else {
                statusLabel.setText("Payment failed.");
            }
        }
    }

    private boolean verifyPayment(double price) {
        // Simulate success
        return true;
    }

    @FXML
    public void restaurantComboBox(ActionEvent actionEvent) {
    }

    @FXML
    public void confirmButton(ActionEvent actionEvent) {
    }
}
