package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BestSellItemController {

    @FXML
    private TextArea messageTA;

    @FXML
    private TextField nameTF;

    @FXML
    private Label textLabel;

    @javafx.fxml.FXML
    public void initialize() {
        textLabel.setText("");
    }


    @FXML
    void backMenuButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/cashier.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cashier Dasboard");
        stage.show();

    }

    @FXML
    public void sendMessageButton(ActionEvent actionEvent) {
        String itemName = nameTF.getText().trim();
        String message = messageTA.getText().trim();

        if (itemName.isEmpty() || message.isEmpty()) {
            textLabel.setText("Please enter item name and message.");
            return;
        }
        textLabel.setText("Message sent for: " + itemName);
        nameTF.clear();
        messageTA.clear();
    }
}
