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

public class UpdateMenuController {

    @FXML
    private ComboBox<String> foodNameCB;

    @FXML
    private TableColumn<UpdateMenu, String> nameCol;

    @FXML
    private TableColumn<UpdateMenu, Double> priceCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableColumn<UpdateMenu, String> ratingCol;

    @FXML
    private ComboBox<String> ratingsCB;

    @FXML
    private TableView<UpdateMenu> tableView;

    @FXML
    private TableColumn<UpdateMenu, Integer> yerterdayCol;

    @FXML
    private TextField yesterdaySellTF;

    @javafx.fxml.FXML
    public void initialize() {
        foodNameCB.getItems().addAll("Pasta", "Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");
        ratingsCB.getItems().addAll("★", "★★", "★★★", "★★★★", "★★★★★");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        yerterdayCol.setCellValueFactory(new PropertyValueFactory<>("yesterdaySell"));
    }

    private ArrayList<UpdateMenu> Updates=new ArrayList<>();


    @FXML
    void addToMenuButton(ActionEvent event) {

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

}
