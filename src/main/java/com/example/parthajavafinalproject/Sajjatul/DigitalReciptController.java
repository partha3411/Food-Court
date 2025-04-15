package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DigitalReciptController {

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private ComboBox<?> foodNameCB;

    @FXML
    private TableColumn<?, ?> itemCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField nameTF;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @FXML
    void backMenuButton(ActionEvent event) {

    }

    @FXML
    void downloadButton(ActionEvent event) {

    }

}
