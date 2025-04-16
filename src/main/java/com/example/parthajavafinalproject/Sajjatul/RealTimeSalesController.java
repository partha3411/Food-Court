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

public class RealTimeSalesController {

    @FXML
    private ComboBox<String> itemAddCB;

    @FXML
    private ComboBox<String> itemOrderCB;

    @FXML
    private TableColumn<RealTimeSales, String> nameCol;

    @FXML
    private TextField quantityAddTF;

    @FXML
    private TextField quantityOrderTF;

    @FXML
    private TableColumn<RealTimeSales, Integer> remainCol;

    @FXML
    private TableView<RealTimeSales> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        itemAddCB.getItems().addAll("Pasta", "Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");
        itemOrderCB.getItems().addAll("Pasta","Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        remainCol.setCellValueFactory(new PropertyValueFactory<>("remainQuantity"));
    }

    private ArrayList<RealTimeSales> RealTimeSalesArray = new ArrayList<>();

    @FXML
    void addItemButton(ActionEvent event) {

    }

    @FXML
    void backMenuButton(ActionEvent event) throws IOException {
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
    void orderButton(ActionEvent event) {

    }

}
