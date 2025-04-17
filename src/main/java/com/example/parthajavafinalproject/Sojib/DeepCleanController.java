package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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

public class DeepCleanController {

@FXML
private TableView<DeepClean> DeepClean;

@FXML
private TableColumn<DeepClean, LocalDate> dateTable;

@FXML
private TableColumn<DeepClean, String> reportTable;

@FXML
private DatePicker Dateofissue;

@FXML
private TextArea comment;

@FXML
private CheckBox floor;

@FXML
private CheckBox sanitize;

@FXML
private CheckBox etb;

private final ObservableList<DeepClean> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        dateTable.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDate()));
        reportTable.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getReport()));

        DeepClean.setItems(data);
    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Sojib/CleaningTasksController.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Cleaner Dashboard");
        stage.show();
    }

    @FXML
    public void reportgen(ActionEvent event) {
        LocalDate date = Dateofissue.getValue();
        if (date == null) {
            showAlert("Please select a date.");
            return;
        }

        StringBuilder reportBuilder = new StringBuilder();
        if (floor.isSelected()) reportBuilder.append("Scrub Floor, ");
        if (sanitize.isSelected()) reportBuilder.append("Sanitize, ");
        if (etb.isSelected()) reportBuilder.append("Empty Trash Bin, ");

        String commentText = comment.getText().trim();
        if (!commentText.isEmpty()) {
            reportBuilder.append("Comment: ").append(commentText);
        }

        if (reportBuilder.isEmpty()) {
            showAlert("Please check at least one task or add a comment.");
            return;
        }

        String report = reportBuilder.toString().replaceAll(", $", "");
        data.add(new DeepClean(date, report));

        // Clear input
        Dateofissue.setValue(null);
        floor.setSelected(false);
        sanitize.setSelected(false);
        etb.setSelected(false);
        comment.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Input Needed");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
