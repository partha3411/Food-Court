module com.example.parthajavafinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.parthajavafinalproject to javafx.fxml;
    exports com.example.parthajavafinalproject;
}