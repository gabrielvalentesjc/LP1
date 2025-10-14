module com.example.lp1_e1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lp1_e1 to javafx.fxml;
    exports com.example.lp1_e1;
    exports com.example.lp1_e1.Controller;
    opens com.example.lp1_e1.Controller to javafx.fxml;
}