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

public class StockManagementController {

    @FXML
    private TableColumn<StockManagement, Integer> howLongCol;

    @FXML
    private ComboBox<String> itemCB;

    @FXML
    private TableColumn<StockManagement, String> nameCol;

    @FXML
    private TableColumn<StockManagement, Integer> quantityCol;

    @FXML
    private TextField quantityFilterTF;

    @FXML
    private TextField quantityTF;

    @FXML
    private TableView<StockManagement> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        itemCB.getItems().addAll("Rice", "Vegetables", "Chicken", "Oil", "Spices", "Fish","Beef","Mutton");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        howLongCol.setCellValueFactory(new PropertyValueFactory<>("howLong"));
    }

    ArrayList<StockManagement> stockManagements=new ArrayList<>();



    @FXML
    void addKitchenButton(ActionEvent event) {
        String item = itemCB.getValue();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityTF.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity");
            return;
        }

        int howLong = (int)(Math.random() * 10) + 1;

        StockManagement product = new StockManagement(item, quantity, howLong);
        writestockManagement(product);

        stockManagements = readStockManagement();

        for (StockManagement stockManagement : stockManagements) {
            tableView.getItems().add(stockManagement);
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
        int filterQuantity;
        try {
            filterQuantity = Integer.parseInt(quantityFilterTF.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid filter value");
            return;
        }

        tableView.getItems().clear();
        for (StockManagement product : stockManagements) {
            if (product.getQuantity() >= filterQuantity) {
                tableView.getItems().add(product);
            }

        }


    }

    public ArrayList<StockManagement> readStockManagement() {
        ArrayList<StockManagement> stall = new ArrayList<>() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("stockFile.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            StockManagement stockManagement;
            try{
                while(true){
                    stockManagement = (StockManagement) ois.readObject();
                    stall.add(stockManagement) ;
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
        return stall ;
    }

    public void writestockManagement(StockManagement stockManagement) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("stockFile.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(stockManagement);

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
