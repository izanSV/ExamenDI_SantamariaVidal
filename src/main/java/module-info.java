module com.example.examen_di_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examen_di_2 to javafx.fxml;
    exports com.example.examen_di_2;
}