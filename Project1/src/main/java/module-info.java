module Data {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.oracle.database.jdbc;
    requires java.sql;
    requires java.naming;
    requires java.desktop;

    opens Data to javafx.fxml;
    exports Data;
}