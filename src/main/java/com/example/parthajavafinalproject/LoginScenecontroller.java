package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("waiterDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Waiter Dashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String id = idTextField.getText();
        String password = passwordTextField.getText();
        String userType = userTypeComboBox.getValue();

        if (id.isEmpty() || password.isEmpty() || userType == null) {
            System.out.println("Please fill all fields.");
            return;
        }

        try {
            FXMLLoader fxmlLoader = null;

            switch (userType) {
                case "Manager":
                    fxmlLoader = new FXMLLoader(getClass().getResource("Sajjatul/manager.fxml"));
                    System.out.println("Login Successful");
                    break;
                case "Cashier":
                    fxmlLoader = new FXMLLoader(getClass().getResource("Sajjatul/cashier.fxml"));
                    System.out.println("Login Successful");
                    break;

                case "Cleaning Stuff":
                    fxmlLoader = new FXMLLoader(getClass().getResource("Sojib/CleaningTasksController.fxml"));
                    System.out.println("Login Successful");
                    break;

                default:
                    System.out.println("Unknown user type.");
                    return;
            }

            if (fxmlLoader != null) {
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setTitle(userType + " Dashboard");
                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void chefLoginOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefDashboardScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Chef DashBoard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }


    }
    /// ///// donot touch this from here
    ///
    @javafx.fxml.FXML
    public void safetyLoginButton(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sojib/HealthTaskBar.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Health and Safety DashBoard");
            stage.setScene(nextScene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void cleanerLoginButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sojib/CleaningTasksController.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Cleaning DashBoard");
            stage.setScene(nextScene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}