package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
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
import java.time.LocalDate;
import java.util.ArrayList;

public class StaffController {

    @FXML
    private TableColumn<Staff, LocalDate> dateCol;

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
    @FXML
    private DatePicker joiningDP;

    @javafx.fxml.FXML
    public void initialize() {
        staffCB.getItems().addAll( "Cleaner", "Security", "Cashier","Chef","Waiter");
        staffDilterCB.getItems().addAll( "Cleaner", "Security", "Cashier","Chef","Waiter");

        staffCol.setCellValueFactory(new PropertyValueFactory<>("staffType"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nidCol.setCellValueFactory(new PropertyValueFactory<>("nid"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("joiningDate"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    ArrayList<Staff> Staffs=new ArrayList<>();


    @FXML
    void addStaffButton(ActionEvent event) {
        String type = staffCB.getValue();
        String name = nameTF.getText();
        String nidText = nidTF.getText();
        String salaryText = salaryTF.getText();
        LocalDate joinDate = joiningDP.getValue();

        if (type == null || name.isEmpty() || nidText.isEmpty() || salaryText.isEmpty()) {
            System.out.println("Please Enter all input");
            return;
        }

        try {
            int nid = Integer.parseInt(nidText);
            int salary = Integer.parseInt(salaryText);


            Staff newStaff = new Staff(joinDate, name, nid, salary, type);
            Staffs.add(newStaff);
            tableView.getItems().add(newStaff);
            System.out.println("Staff added: " + name);

        } catch (NumberFormatException e) {
            System.out.println("NID and Salary must be inputed.");
        }
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
        String filterType = staffDilterCB.getValue();
        if (filterType == null)
            return;

        tableView.getItems().clear();
        for (Staff newStaff : Staffs) {
            if (newStaff.getStaffType().equals(filterType)) {
                tableView.getItems().add(newStaff);
            }
        }
    }


}
