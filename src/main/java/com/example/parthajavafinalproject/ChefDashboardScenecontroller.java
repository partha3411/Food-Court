package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChefDashboardScenecontroller
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void processOrderButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefProcessanOrderScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Login Scene");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }
    }

    @javafx.fxml.FXML
    public void inventorymangementButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefEnsuresKitchenInventoryIsEnoughScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Inventory management");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void prepareAspecialDishButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefPreparesAspecialDishScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Prepare a special Dish");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void updateOrderStatusButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefProcessanOrderScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Update Order");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Login Scene");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void notificationfromwaiterButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefRecievesNotificationsScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Notifications");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void viewSpecificCustomerOrderButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefViewsSpecificCustomerOrderScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Specific Customer Order");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void customerfeedbackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Login Scene");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void ReviewmodifiedOrderButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefReviewsModifiedOrderScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("See modified Orders");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}