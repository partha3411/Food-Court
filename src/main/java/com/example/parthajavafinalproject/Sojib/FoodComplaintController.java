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
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FoodComplaintController {

    @FXML
    private DatePicker date;
    @FXML
    private TextField name;
    @FXML
    private ListView<String> textdetails;
    @FXML
    private TextField comment;
    @FXML
    private TableView<FoodComplaint> FoodComplaint;
    @FXML
    private TableColumn<FoodComplaint, LocalDate> datetable;
    @FXML
    private TableColumn<FoodComplaint, String> nameTable;
    @FXML
    private TableColumn<FoodComplaint, String> commentTable;

    private final ObservableList<FoodComplaint> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Setup table columns
        datetable.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        nameTable.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        commentTable.setCellValueFactory(cellData -> cellData.getValue().commentProperty());

        // Bind data
        FoodComplaint.setItems(dataList);

        // Optionally populate some example checklist items
        textdetails.setItems(FXCollections.observableArrayList(
                "Check refrigerated storage",
                "Inspect food preparation areas",
                "Verify proper food handling",
                "Ensure hygiene of food handlers"
        ));
    }

    @FXML
    public void submitButton(ActionEvent actionEvent) {
        LocalDate selectedDate = date.getValue();
        String inspector = name.getText();
        String complianceComment = comment.getText();

        if (selectedDate == null || inspector.isEmpty() || complianceComment.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all fields before submitting.");
            alert.showAndWait();
            return;
        }

        FoodComplaint complaint = new FoodComplaint(selectedDate, inspector, complianceComment);
        dataList.add(complaint);
        date.setValue(null);
        name.clear();
        comment.clear();
        textdetails.getSelectionModel().clearSelection();
    }
    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(""));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();

    }
}
//sojib