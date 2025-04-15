package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ChatController {

    @FXML
    private TableColumn<?, ?> customerCol;

    @FXML
    private TextArea customerMessageTA;

    @FXML
    private TableColumn<?, ?> managerCol;

    @FXML
    private TextArea managerMessageTA;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void backMenuButton(ActionEvent event) {

    }

    @FXML
    void customerSendButton(ActionEvent event) {

    }

    @FXML
    public void managerSendButton(ActionEvent actionEvent) {
    }
}
