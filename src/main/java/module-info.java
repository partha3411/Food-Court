module com.example.parthajavafinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.parthajavafinalproject to javafx.fxml;
    opens com.example.parthajavafinalproject.Sajjatul to javafx.fxml, javafx.base;
    exports com.example.parthajavafinalproject;
    opens com.example.parthajavafinalproject.Sojib to javafx.fxml, javafx.base;
    exports com.example.parthajavafinalproject.Sojib;
    opens com.example.parthajavafinalproject.Sabbir to javafx.fxml;
    exports com.example.parthajavafinalproject.Sabbir;
    opens com.example.parthajavafinalproject.sahadat to javafx.fxml,javafx.base;
    exports com.example.parthajavafinalproject.sahadat;
}