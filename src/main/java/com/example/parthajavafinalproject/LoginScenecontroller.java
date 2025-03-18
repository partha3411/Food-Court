package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class LoginScenecontroller
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField passwordTextField;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Manager","Cashier","Customer","Food Delivery partner","supplier","Cleaning Stuff","Health and Safety Officers");

    }

    @javafx.fxml.FXML
    public void waiterLoginButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void chefLoginOnAction(ActionEvent actionEvent) {
    }
}