package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.AppendableObjectOutputStream;
import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class CreateAccountController {
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField numberTF;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private Label textLabel;
    @javafx.fxml.FXML
    private DatePicker dobDP;
    @javafx.fxml.FXML
    private ComboBox<String> staffCB;
    @javafx.fxml.FXML
    private TextField idTF;

    private ArrayList<Cashier> cashier = new ArrayList<>();
    private ArrayList<Manager> manager = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        staffCB.getItems().addAll("Manager", "Cashier", "Customer", "Food Delivery partner", "supplier", "Cleaning Stuff", "Health and Safety Officers");
    }


    @javafx.fxml.FXML
    public void confirmCreateAccount(ActionEvent actionEvent) {
        Integer id = Integer.parseInt(idTF.getText());
        String name = nameTF.getText();
        String email = emailTF.getText();
        String phone = numberTF.getText();
        String password = passwordPF.getText();
        String staffType = (String) staffCB.getValue();
        LocalDate dob = dobDP.getValue();


        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || staffType == null || dob == null) {
            textLabel.setText("Please fill all fields");
            return;
        }

        switch (staffType) {
            case "Cashier":
                Cashier cashier = new Cashier(dob, email, id, name, password, phone);
                writeCashier(cashier);
                break;

            case "Manager":
                Manager manager = new Manager(dob, email, id, name, password, phone);
                writeManager(manager);
                break;

            default:
                textLabel.setText("Input all Field to create account");
                return;
        }

        textLabel.setText("✔ Account Created Successfully!");
        idTF.clear();
        nameTF.clear();
        emailTF.clear();
        numberTF.clear();
        passwordPF.clear();
        staffCB.setValue(null);
        dobDP.setValue(null);
    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginScene.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login User");
        stage.show();
    }

    public void writeCashier(Cashier cashier) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("cashierFile.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(cashier);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void writeManager(Manager manager) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("managerFile.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(manager);

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
