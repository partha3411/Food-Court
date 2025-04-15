package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RatingsController {

    @FXML
    private TableColumn<?, ?> feedbackCol;

    @FXML
    private TextField feedbackTF;

    @FXML
    private ComboBox<?> fooNameCB;

    @FXML
    private TableColumn<?, ?> foodNameCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField nameTF;

    @FXML
    private ComboBox<?> ratingCB;

    @FXML
    private TableColumn<?, ?> ratingCol;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void backMenuButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/manager.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manager Dashboard");
        stage.show();

    }

    @FXML
    void filterButton(ActionEvent event) {

    }

    @FXML
    void ratingDilterCB(ActionEvent event) {

    }

    @FXML
    void submitButton(ActionEvent event) {

    }

}
