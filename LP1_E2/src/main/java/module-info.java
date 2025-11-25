module org.example.lp1_e2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;

    // Permite que o FXML acesse os Controllers no pacote principal
    opens org.example.lp1_e2 to javafx.fxml;

    // --- CORREÇÃO AQUI ---
    // Abre o pacote Model para o javafx.base (que contém a TableView/PropertyValueFactory)
    opens org.example.lp1_e2.Model to javafx.base;

    exports org.example.lp1_e2;
}