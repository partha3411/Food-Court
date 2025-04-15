package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StockManagementController {

    @FXML
    private TableColumn<?, ?> howLongCol;

    @FXML
    private ComboBox<?> itemCB;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> quantityCol;

    @FXML
    private TextField quantityFilterTF;

    @FXML
    private TextField quantityTF;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @FXML
    void addKitchenButton(ActionEvent event) {

    }

    @FXML
    void backMenuButton(ActionEvent event) {

    }

    @FXML
    void filterButton(ActionEvent event) {

    }

}
