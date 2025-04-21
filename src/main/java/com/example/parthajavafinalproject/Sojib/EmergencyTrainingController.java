package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;

public class EmergencyTrainingController {
    @FXML
    private RadioButton EE;
    @FXML
    private RadioButton firee;
    @FXML
    private RadioButton FAK;
    @FXML
    private TableColumn<EmergencyTraining, String> nameTable;
    @FXML
    private Label QArea;
    @FXML
    private TableColumn<EmergencyTraining, String> chooseTbale;
    @FXML
    private TableView<EmergencyTraining> EmergencyTraining;
    @FXML
    private TableColumn<EmergencyTraining, String> doneTable;
    @FXML
    private TextField Ename;

    private ToggleGroup answerGroup = new ToggleGroup();
    private ObservableList<EmergencyTraining> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        firee.setToggleGroup(answerGroup);
        FAK.setToggleGroup(answerGroup);
        EE.setToggleGroup(answerGroup);

        nameTable.setCellValueFactory(data -> data.getValue().nameProperty());
        doneTable.setCellValueFactory(data -> data.getValue().doneProperty());
        chooseTbale.setCellValueFactory(data -> data.getValue().chosenProperty());

        EmergencyTraining.setItems(list);
    }

    @FXML
    public void submit(ActionEvent actionEvent) {
        String name = Ename.getText();
        Toggle selectedToggle = answerGroup.getSelectedToggle();

        if (name.isEmpty() || selectedToggle == null) {
            QArea.setText("Please enter name and select an answer.");
            return;
        }
        RadioButton selected = (RadioButton) selectedToggle;
        String choice = selected.getText();
        EmergencyTraining record = new EmergencyTraining(name, "Yes", choice);
        list.add(record);
        Ename.clear();
        answerGroup.selectToggle(null);
        QArea.setText("Answer Submitted!");
    }
    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sojib/HealthTaskBar.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();
    }
}
