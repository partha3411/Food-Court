package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerShareOrderController {

    @FXML
    private TextField shareLinkField;

    @FXML
    private ComboBox<String> orderCB;

    @FXML
    private ListView<String> listV;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    public void initialize() {
        orderCB.getItems().addAll("pizza", "burger", "sushi", "taco");
    }

    @FXML
    public void customerDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("sahadat/customerDashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }

    @FXML
    public void tF(ActionEvent actionEvent) {

    }

    @FXML
    public void linkButton(ActionEvent actionEvent) {
        String selectedItem = orderCB.getValue();
        if (selectedItem != null) {
            String generatedLink = "https://example.com/share?order=" + selectedItem;
            shareLinkField.setText(generatedLink);
            label.setText("Link generated!");
        } else {
            label.setText("Please select an item from the dropdown.");
        }
    }

    @FXML
    public void orderButton(ActionEvent actionEvent) {
        listV.getItems().clear();
        for (String item : orderCB.getItems()) {
            if (!listV.getItems().contains(item)) {
                listV.getItems().add(item);
            }
        }
        label1.setText("Order Confirmed");
        label.setText("");
    }
}
