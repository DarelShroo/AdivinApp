module com.dad.adivinapp.adivinapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dad.adivinapp to javafx.fxml;
    exports com.dad.adivinapp;
}