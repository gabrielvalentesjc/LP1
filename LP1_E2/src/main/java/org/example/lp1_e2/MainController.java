package org.example.lp1_e2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MainController {

    // Modifique este método:
    @FXML
    private void goToMusica(ActionEvent event) throws IOException {
        // Mudou de MusicaTab.fxml para MusicaMain.fxml
        loadScene("MusicaMain.fxml", event);
    }

    @FXML
    private void goToVikMuniz(ActionEvent event) throws IOException {
        loadScene("VikMunizTab.fxml", event);
    }

    @FXML
    private void goToDoodle(ActionEvent event) throws IOException {
        loadScene("DoodleTab.fxml", event);
    }

    @FXML
    private void goToVideo(ActionEvent event) throws IOException {
        loadScene("VideoTab.fxml", event);
    }

    private void loadScene(String fxmlPath, ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/lp1_e2/" + fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

