package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;+
import javafx.scene.control.TableView;

public class UserActivityController {

    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private Button checkLogsButton;
    @FXML
    private TableView<> logTable;
    @FXML
    private TableColumn<UserActivityLog, String> timestampColumn;
    @FXML
    private TableColumn<UserActivityLog, String> actionColumn;

    public ComboBox<String> getUserComboBox() {
        return userComboBox;
    }

    public void setUserComboBox(ComboBox<String> userComboBox) {
        this.userComboBox = userComboBox;
    }

    public Button getCheckLogsButton() {
        return checkLogsButton;
    }

    public void setCheckLogsButton(Button checkLogsButton) {
        this.checkLogsButton = checkLogsButton;
    }

    public TableView<UserActivityLog> getLogTable() {
        return logTable;
    }

    public void setLogTable(TableView<UserActivityLog> logTable) {
        this.logTable = logTable;
    }

    public TableColumn<UserActivityLog, String> getTimestampColumn() {
        return timestampColumn;
    }

    public void setTimestampColumn(TableColumn<UserActivityLog, String> timestampColumn) {
        this.timestampColumn = timestampColumn;
    }

    public TableColumn<UserActivityLog, String> getActionColumn() {
        return actionColumn;
    }

    public void setActionColumn(TableColumn<UserActivityLog, String> actionColumn) {
        this.actionColumn = actionColumn;
    }
}
