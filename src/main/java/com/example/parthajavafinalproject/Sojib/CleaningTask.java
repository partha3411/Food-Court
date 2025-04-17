package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CleaningTask {

    @FXML
    private TextField WorkingPerson;
    @FXML
    private TextField Task;
    @FXML
    private DatePicker CleaningDate;
    @FXML
    private TextField CleaningArea;
    @FXML
    private TableColumn<CleaningRecord, String> TaskList;
    @FXML
    private TableColumn<CleaningRecord, String> Person;
    @FXML
    private TableColumn<CleaningRecord, String> Date;
    @FXML
    private TableColumn<CleaningRecord, String> Areas;
    @FXML
    private TableView<CleaningRecord> tableView;

    private final ObservableList<CleaningRecord> taskList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        Areas.setCellValueFactory(new PropertyValueFactory<>("area"));
        Person.setCellValueFactory(new PropertyValueFactory<>("person"));
        TaskList.setCellValueFactory(new PropertyValueFactory<>("task"));

        tableView.setItems(taskList);
    }

    @FXML
    public void CompletedWork(ActionEvent actionEvent) {
        String date = (CleaningDate.getValue() != null) ? CleaningDate.getValue().toString() : "";
        String area = CleaningArea.getText();
        String person = WorkingPerson.getText();
        String task = Task.getText();

        if (!date.isEmpty() && !area.isEmpty() && !person.isEmpty() && !task.isEmpty()) {
            taskList.add(new CleaningRecord(date, area, person, task));
            CleaningDate.setValue(null);
            CleaningArea.clear();
            WorkingPerson.clear();
            Task.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill all fields!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sojib/CleaningTasksController.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }

}
