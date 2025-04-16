package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TimeController {

    @FXML
    private TableColumn<Time, String> closingCol;

    @FXML
    private TextField closingTF;

    @FXML
    private ComboBox<String> offDayCB;

    @FXML
    private TableColumn<Time, String> offDayCol;

    @FXML
    private TableColumn<Time, String> openingCol;

    @FXML
    private TextField openingTF;

    @FXML
    private TableView<Time> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        offDayCB.getItems().addAll("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

        openingCol.setCellValueFactory(new PropertyValueFactory<>("openingTime"));
        closingCol.setCellValueFactory(new PropertyValueFactory<>("closingTime"));
        offDayCol.setCellValueFactory(new PropertyValueFactory<>("offDay"));
    }

    private ArrayList<Time> Times = new ArrayList<>();

    @FXML
    void addScheduleButton(ActionEvent event) {

    }

    @FXML
    public void backMenuButton(ActionEvent actionEvent)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/manager.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manager Dashboard");
        stage.show();
    }
}
