package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TimeController {

    @FXML
    private TableColumn<?, ?> closingCol;

    @FXML
    private TextField closingTF;

    @FXML
    private ComboBox<?> offDayCB;

    @FXML
    private TableColumn<?, ?> offDayCol;

    @FXML
    private TableColumn<?, ?> openingCol;

    @FXML
    private TextField openingTF;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void addScheduleButton(ActionEvent event) {

    }

}
