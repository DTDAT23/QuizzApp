module com.dtd.quizzapp.quizzapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dtd.quizzapp.quizzapp to javafx.fxml;
    exports com.dtd.quizzapp.quizzapp;
}
