package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HealthTaskBar {


    @FXML
    void FireSafety(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FireSafety.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }
    @FXML
    void Foodhandle(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FoodComplaint.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }
    @FXML
    void CodeVio(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HealthCOdeViolation.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }

    @FXML
    void FoodStoreage(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FoodStorage.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }

    @javafx.fxml.FXML
    public void accidentReport() {
    }

    @FXML
    void EmergencyRes(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EmergencyTraining.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }

    @javafx.fxml.FXML
    void HealthSafetyOffice(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RoutineSafety.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }
    @javafx.fxml.FXML
    public void guidline(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Logout(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("src/main/resources/com/example/parthajavafinalproject/loginScene.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Dashboard");
        stage.show();

    }
}
