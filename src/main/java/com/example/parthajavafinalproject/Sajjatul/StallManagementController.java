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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class StallManagementController {

    @FXML
    private TableColumn<StallManagement, LocalDate> billingDateColoumn;

    @FXML
    private ComboBox<String> durationComboBox;

    @FXML
    private Text label;

    @FXML
    private TableColumn<StallManagement, LocalDate> nextBillingDateColoumn;

    @FXML
    private ComboBox<String> paymentComboBox;

    @FXML
    private ComboBox<String> stallComboBox;

    @FXML
    private TableColumn<StallManagement, String> stallNameColoumn;

    @FXML
    private TableColumn<StallManagement, String> statusColoumn;

    @FXML
    private TableView<StallManagement> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        stallComboBox.getItems().addAll("Food Stall 1","Food Stall 2","Food Stall 3");
        durationComboBox.getItems().addAll("1 Month","2 Month","3 Month","6 Month ");
        paymentComboBox.getItems().addAll("Cash","Bkash","Nagad","Rocket","Upay","Card");

        stallNameColoumn.setCellValueFactory(new PropertyValueFactory<>("stallName"));
        billingDateColoumn.setCellValueFactory(new PropertyValueFactory<>("billingDate"));
        nextBillingDateColoumn.setCellValueFactory(new PropertyValueFactory<>("nextBillingDate"));
        statusColoumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    ArrayList<StallManagement> stallManagements=new ArrayList<>();

    @FXML
    void confirmButton(ActionEvent event) {
        String stall = stallComboBox.getValue();
        String duration = durationComboBox.getValue();
        String payment = paymentComboBox.getValue();

        if (stall==null || duration==null || payment==null) {
            label.setText("Please select all fields");
            return;
        }
        LocalDate today = LocalDate.now();
        LocalDate nextBillingDate = switch (duration){
            case "1 Month"-> today.plusMonths(1);
            case "2 Month"-> today.plusMonths(2);
            case "3 Month"-> today.plusMonths(3);
            case "6 Month"-> today.plusMonths(6);
            default -> today.plusMonths(1);
        };

        String status = payment.equals("Cash") ? "Paid Offline" : "Paid Online";

        StallManagement info = new StallManagement(stall, today, nextBillingDate, status);
        label.setText("Billing confirmed for " + stall);
        tableView.getItems().add(info);
    }

    @FXML
    void downloadReceiptButton(ActionEvent event) {
        String stall = stallComboBox.getValue();
        String duration = durationComboBox.getValue();
        String payment = paymentComboBox.getValue();
        tableView.getItems().clear();
        LocalDate today = LocalDate.now();
        LocalDate nextBillingDate = switch (duration){
            case "1 Month"-> today.plusMonths(1);
            case "2 Month"-> today.plusMonths(2);
            case "3 Month"-> today.plusMonths(3);
            case "6 Month"-> today.plusMonths(6);
            default -> today.plusMonths(1);
        };

        String status = payment.equals("Cash") ? "Paid Offline" : "Paid Online";

        StallManagement info = new StallManagement(stall, today, nextBillingDate, status);
        label.setText("Dowloaded");
        tableView.getItems().add(info);


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
