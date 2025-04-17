package com.example.parthajavafinalproject.Sojib;

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
import java.time.LocalDate;

public class FoodStorageController {
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn<FoodStorage, String> nameTable;
    @javafx.fxml.FXML
    private TableView<FoodStorage> FoodStorage;
    @javafx.fxml.FXML
    private TableColumn<FoodStorage, LocalDate> dateTable;
    @javafx.fxml.FXML
    private ComboBox<String> taken;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TextArea action;
    @javafx.fxml.FXML
    private TableColumn<FoodStorage, String> actionTable;
    @javafx.fxml.FXML
    private TableColumn<FoodStorage, String> actionTyTable;

    @javafx.fxml.FXML
    public void submit(ActionEvent actionEvent) {
    }

    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(""));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();
    }
}
