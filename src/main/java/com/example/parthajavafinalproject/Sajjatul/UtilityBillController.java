package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UtilityBillController {

    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private TextField amountTF;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private Label label;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableView<?> tableView;

    @FXML
    private ComboBox<?> utilityNameCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void backMenuButton(ActionEvent event) {

    }

    @FXML
    void payBillButton(ActionEvent event) {

    }

}
