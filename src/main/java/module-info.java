module com.example.projectofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectofinal to javafx.fxml;
    exports com.example.projectofinal;
}