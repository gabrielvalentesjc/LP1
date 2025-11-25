module org.example.lp1_e2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;


    opens org.example.lp1_e2 to javafx.fxml;
    exports org.example.lp1_e2;
}