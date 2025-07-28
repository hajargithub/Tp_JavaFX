module ma.enset.tp_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ma.enset.tp_javafx to javafx.fxml;
    exports ma.enset.tp_javafx;
}