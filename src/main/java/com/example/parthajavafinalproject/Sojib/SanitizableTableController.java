package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SanitizableTableController {

    @FXML
    private CheckBox sanitizeop;
    @FXML
    private CheckBox wipesurface;
    @FXML
    private CheckBox cleantable;
    @FXML
    private TableColumn<HistoryTable, String> historyk;
    @FXML
    private TextField user;
    @FXML
    private CheckBox disinfectedge;
    @FXML
    private TableView<String> HistoryTable;

    private final ObservableList<String> historyData = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        historyk.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().toString()));
        HistoryTable.setItems(historyData);
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sojib/CleaningTasksController.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();
    }

    @FXML
    public void MarkAsCleaned(ActionEvent actionEvent) {
// Not done yet

    }
}
