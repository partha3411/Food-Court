package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BillingStaffController {

    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private TextField amountTF;

    @FXML
    private TableColumn<?, ?> categoryCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private ComboBox<?> staffCB;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Label textLabel;

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
