package org.example.lp1_e2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class MusicaMainController {

    @FXML
    private void abrirCrudPessoa(ActionEvent event) throws IOException {
        navegar(event, "CrudPessoa.fxml");
    }

    @FXML
    private void abrirCrudSol(ActionEvent event) throws IOException {
        navegar(event, "CrudSol.fxml");
    }

    @FXML
    private void abrirCrudDia(ActionEvent event) throws IOException {
        navegar(event, "CrudDia.fxml");
    }

    @FXML
    private void voltarParaMain(ActionEvent event) throws IOException {
        navegar(event, "main-view.fxml");
    }

    private void navegar(ActionEvent event, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/lp1_e2/" + fxml));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}