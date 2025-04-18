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

public class CleaningTasksController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void RestockCleanSupply(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RestockCleanSupply.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }

    @javafx.fxml.FXML
    void SanitizableTable(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SanitizableTable.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }
    @javafx.fxml.FXML
    void GarbageWasteDesposal(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SanitizableTable.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }
    @javafx.fxml.FXML
    void SpillCleanup(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SpillCleanup.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }
    @javafx.fxml.FXML
    void DeepClean(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DeepClean.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }
    @javafx.fxml.FXML
    void CleaningTask(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CleaningTask.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }
    @javafx.fxml.FXML
    void HygienicCondition(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HygienicCondition.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }

    @FXML
    void MaintenanceIssues(ActionEvent event)  throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MaintenanceIssues.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

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