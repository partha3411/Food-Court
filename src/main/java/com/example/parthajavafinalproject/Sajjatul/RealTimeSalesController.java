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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class RealTimeSalesController {

    @FXML
    private ComboBox<String> itemAddCB;

    @FXML
    private ComboBox<String> itemOrderCB;

    @FXML
    private TableColumn<RealTimeSales, String> nameCol;

    @FXML
    private TextField quantityAddTF;

    @FXML
    private TextField quantityOrderTF;

    @FXML
    private TableColumn<RealTimeSales, Integer> remainCol;

    @FXML
    private TableView<RealTimeSales> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        itemAddCB.getItems().addAll("Pasta", "Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");
        itemOrderCB.getItems().addAll("Pasta","Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        remainCol.setCellValueFactory(new PropertyValueFactory<>("remainQuantity"));
    }

    private ArrayList<RealTimeSales> realTimeSalesArray = new ArrayList<>();

    @FXML
    void addItemButton(ActionEvent event) {
        String item = itemAddCB.getValue();
        String quantityText = quantityAddTF.getText();

        if (item == null || quantityText.isEmpty()) {
            System.out.println("Please input all the items");
            return;
        }

        int quantity = Integer.parseInt(quantityText);


        for (RealTimeSales sales : realTimeSalesArray) {
            if (sales.getItemName().equals(item)) {
                sales.setRemainQuantity(sales.getRemainQuantity() + quantity);
                tableView.refresh();
                return;
            }
        }

        RealTimeSales newItem = new RealTimeSales(item, quantity);
        tableView.getItems().add(newItem);
        writestallManagement(newItem);

        quantityAddTF.clear();
        itemAddCB.setValue(null);
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
    void orderButton(ActionEvent event) {
        String item = itemOrderCB.getValue();
        String quantityText = quantityOrderTF.getText();

        if (item == null || quantityText.isEmpty()) {
            System.out.println("Please input all");
            return;
        }

        int quantity = Integer.parseInt(quantityText);

        realTimeSalesArray=readrealTimeSales();
        for (RealTimeSales sales : realTimeSalesArray) {
            if (sales.getItemName().equals(item)) {
                int current = sales.getRemainQuantity();
                if (quantity > current) {
                    System.out.println("stock out!");
                    return;
                }
                sales.setRemainQuantity(current - quantity);
                tableView.refresh();
                return;
            }
        }
    }

    public ArrayList<RealTimeSales> readrealTimeSales() {
        ArrayList<RealTimeSales> real = new ArrayList<>() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("saleFile.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            RealTimeSales realTimeSales;
            try{
                while(true){
                    realTimeSales = (RealTimeSales) ois.readObject();
                    real.add(realTimeSales) ;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("External Error: " + ex.getMessage());
        }
        finally {
            try {

                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return real ;
    }

    public void writestallManagement(RealTimeSales realTimeSales) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("saleFile.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(realTimeSales);

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
