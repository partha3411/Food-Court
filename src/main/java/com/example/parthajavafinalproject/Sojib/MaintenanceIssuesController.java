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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class MaintenanceIssuesController {

    @FXML
    private RadioButton MediumRadio;
    @FXML
    private TableColumn<MaintainModel, String> problemTable;
    @FXML
    private TextField issue;
    @FXML
    private DatePicker dateofissue;
    @FXML
    private TableColumn<MaintainModel, LocalDate> dateTable;
    @FXML
    private RadioButton LowRadio;
    @FXML
    private TableColumn<MaintainModel, String> riskTable;
    @FXML
    private RadioButton HighRadio;
    @FXML
    private TableView<MaintainModel> maintainTable;

    private final ToggleGroup riskGroup = new ToggleGroup();
    private final ObservableList<MaintainModel> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        LowRadio.setToggleGroup(riskGroup);
        MediumRadio.setToggleGroup(riskGroup);
        HighRadio.setToggleGroup(riskGroup);
        problemTable.setCellValueFactory(cellData -> cellData.getValue().problemProperty());
        dateTable.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        riskTable.setCellValueFactory(cellData -> cellData.getValue().riskProperty());

        maintainTable.setItems(data);
    }

    @FXML
    public void ReportIssue() {
        String issueText = issue.getText();
        LocalDate issueDate = dateofissue.getValue();
        RadioButton selectedRisk = (RadioButton) riskGroup.getSelectedToggle();

        if (issueText.isEmpty() || issueDate == null || selectedRisk == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill all the fields and select a risk level.", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        String riskLevel = selectedRisk.getText();
        MaintainModel model = new MaintainModel(issueText, issueDate, riskLevel);
        data.add(model);
        issue.clear();
        dateofissue.setValue(null);
        riskGroup.selectToggle(null);
    }

    @FXML
    public void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            System.out.println("Selected image: " + selectedFile.getAbsolutePath());
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
