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

public class StockManagementController {

    @FXML
    private TableColumn<StockManagement, Integer> howLongCol;

    @FXML
    private ComboBox<String> itemCB;

    @FXML
    private TableColumn<StockManagement, String> nameCol;

    @FXML
    private TableColumn<StockManagement, Integer> quantityCol;

    @FXML
    private TextField quantityFilterTF;

    @FXML
    private TextField quantityTF;

    @FXML
    private TableView<StockManagement> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        itemCB.getItems().addAll("Rice", "Vegetables", "Chicken", "Oil", "Spices", "Fish","Beef","Mutton");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        howLongCol.setCellValueFactory(new PropertyValueFactory<>("howLong"));
    }

    ArrayList<StockManagement> stockManagements=new ArrayList<>();



    @FXML
    void addKitchenButton(ActionEvent event) {

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
    void filterButton(ActionEvent event) {

    }

}
