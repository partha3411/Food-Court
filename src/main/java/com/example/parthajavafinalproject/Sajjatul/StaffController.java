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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class StaffController {

    @FXML
    private TableColumn<Staff, LocalDate> dateCol;

    @FXML
    private AnchorPane joiningDP;

    @FXML
    private TableColumn<Staff, String> nameCol;

    @FXML
    private TextField nameTF;

    @FXML
    private TableColumn<Staff, Integer> nidCol;

    @FXML
    private TextField nidTF;

    @FXML
    private TableColumn<Staff, Integer> salaryCol;

    @FXML
    private TextField salaryTF;

    @FXML
    private ComboBox<String> staffCB;

    @FXML
    private TableColumn<Staff, String> staffCol;

    @FXML
    private ComboBox<String> staffDilterCB;

    @FXML
    private TableView<Staff> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        staffCB.getItems().addAll( "Cleaner", "Security", "Cashier","Chef","Waiter");
        staffDilterCB.getItems().addAll( "Cleaner", "Security", "Cashier","Chef","Waiter");

        staffCol.setCellValueFactory(new PropertyValueFactory<>("staffType"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nidCol.setCellValueFactory(new PropertyValueFactory<>("nid"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    ArrayList<Staff> Staffs=new ArrayList<>();


    @FXML
    void addStaffButton(ActionEvent event) {

    }

    @FXML
    void backMenuButton(ActionEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/manager.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manager Dashboard");
        stage.show();
    }



    @FXML
    void filterButton(ActionEvent event) {

    }

}
