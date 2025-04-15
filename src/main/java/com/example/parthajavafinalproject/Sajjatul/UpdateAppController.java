package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UpdateAppController {

    @FXML
    private ComboBox<?> foodNameCB;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableColumn<?, ?> ratingCol;

    @FXML
    private ComboBox<?> ratingsCB;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> yerterdayCol;

    @FXML
    private TextField yesterdaySellTF;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @FXML
    void addToMenuButton(ActionEvent event) {

    }

    @FXML
    void backMenuButton(ActionEvent event) {

    }

}
