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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StallManagementController {

    @FXML
    private TableColumn<?, ?> billingDateColoumn;

    @FXML
    private ComboBox<?> durationComboBox;

    @FXML
    private Text label;

    @FXML
    private TableColumn<?, ?> nextBillingDateColoumn;

    @FXML
    private ComboBox<?> paymentComboBox;

    @FXML
    private ComboBox<?> stallComboBox;

    @FXML
    private TableColumn<?, ?> stallNameColoumn;

    @FXML
    private TableColumn<?, ?> statusColoumn;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void confirmButton(ActionEvent event) {

    }

    @FXML
    void downloadReceiptButton(ActionEvent event) {

    }

    @FXML
    public void backMenuButton(ActionEvent actionEvent) throws IOException {
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
