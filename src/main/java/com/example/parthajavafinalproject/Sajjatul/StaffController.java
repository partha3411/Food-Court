package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StaffController {

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private AnchorPane joiningDP;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField nameTF;

    @FXML
    private TableColumn<?, ?> nidCol;

    @FXML
    private TextField nidTF;

    @FXML
    private TableColumn<?, ?> salaryCol;

    @FXML
    private TextField salaryTF;

    @FXML
    private ComboBox<?> staffCB;

    @FXML
    private TableColumn<?, ?> staffCol;

    @FXML
    private ComboBox<?> staffDilterCB;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @FXML
    void addStaffButton(ActionEvent event) {

    }

    @FXML
    void backMenuButton(ActionEvent event) {

    }

    @FXML
    void filterButton(ActionEvent event) {

    }

}
