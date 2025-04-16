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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RatingsController {

    @FXML
    private TableColumn<Ratings, String> feedbackCol;

    @FXML
    private TextField feedbackTF;

    @FXML
    private ComboBox<String> fooNameCB;

    @FXML
    private TableColumn<Ratings, String> foodNameCol;

    @FXML
    private TableColumn<Ratings, String> nameCol;

    @FXML
    private TextField nameTF;

    @FXML
    private ComboBox<String> ratingCB;

    @FXML
    private TableColumn<Ratings, String> ratingCol;

    @FXML
    private TableView<Ratings> tableView;
    @FXML
    private ComboBox<String> ratingFilterCB;

    @javafx.fxml.FXML
    public void initialize() {
        fooNameCB.getItems().addAll("Pasta", "Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");
        ratingCB.getItems().addAll("★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★");
        ratingFilterCB.getItems().addAll("★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        foodNameCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        feedbackCol.setCellValueFactory(new PropertyValueFactory<>("feedback"));
    }

    private ArrayList<Ratings> RatingsArray = new ArrayList<>();

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

    @Deprecated
    void ratingDilterCB(ActionEvent event) {

    }

    @FXML
    void submitButton(ActionEvent event) {

    }

}
