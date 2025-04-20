package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.AppendableObjectOutputStream;
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

import java.io.*;
import java.time.LocalDate;

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
        tableView.getItems().clear();
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
        StallManagement info = new StallManagement( today, nextBillingDate, stall,status);
        System.out.println(info);
        label.setText("Billing confirmed for " + stall);
        stallManagements.add(info);
        tableView.getItems().add(info) ;
    }

    @FXML
    void downloadReceiptButton(ActionEvent event) {
        tableView.getItems().clear();
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

        String status;
        if (payment.equals("Cash")) {
            status = "Paid Offline";
        } else {
            status = "Paid Online";
        }


        StallManagement info = new StallManagement( today, nextBillingDate,stall, status);
        writestallManagement(info);
        label.setText("Dowloaded");
        stallManagements = readStallManagement();

        for (StallManagement stallManagement : stallManagements) {
            tableView.getItems().add(stallManagement);
        }


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

    public ArrayList<StallManagement> readStallManagement() {
        ArrayList<StallManagement> stall = new ArrayList<>() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("stallFile.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            StallManagement stallManagement;
            try{
                while(true){
                    stallManagement = (StallManagement) ois.readObject();
                    stall.add(stallManagement) ;
                }
            }
            catch(Exception e){
                System.out.println("Read Error: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("External Error: " + ex.getMessage());
        }
        finally {
            try {

                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return stall ;
    }

    public void writestallManagement(StallManagement stallManagement) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("stallFile.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(stallManagement);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

}
