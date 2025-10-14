package com.example.lp1_e1.Controller;

import com.example.lp1_e1.DAO.RegistroDAO;
import com.example.lp1_e1.Model.Video.Filha;
import com.example.lp1_e1.Model.Video.Pai;
import com.example.lp1_e1.Model.Video.TutorialVideo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Video_Controller {
    // ============  VIDEO - FILHA ============
    @FXML private TextField filhaNome;
    @FXML private TextField filhaNivelSatisfacao;
    @FXML private TextField filhaHumor;

    // ============  VIDEO - PAI ============
    @FXML private TextField paiNome;
    @FXML private TextField paiNivelHabilidadePentear;
    @FXML private TextField paiEmocao;

    // ============  VIDEO - TUTORIAL VIDEO ============
    @FXML private TextField tutorialVideoTitulo;
    @FXML private TextField tutorialVideoDuracao;
    @FXML private TextField tutorialVideoAutor;

    private final RegistroDAO registroDAO = new RegistroDAO();

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void criarFilha() {
        String nome = filhaNome.getText();
        int nivelSatisfacao = Integer.parseInt(filhaNivelSatisfacao.getText());
        String humor = filhaHumor.getText();

        Filha novaFilha = new Filha(nome, nivelSatisfacao, humor);

        try {
            registroDAO.salvar(novaFilha);
            filhaNome.clear();
            filhaNivelSatisfacao.clear();
            filhaHumor.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados da Filha no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Nível de Satisfação deve ser um número válido.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarPai() {
        String nome = paiNome.getText();
        int nivelHabilidadePentear = Integer.parseInt(paiNivelHabilidadePentear.getText());
        String emocao = paiEmocao.getText();

        Pai novoPai = new Pai(nome, nivelHabilidadePentear, emocao);

        try {
            registroDAO.salvar(novoPai);
            paiNome.clear();
            paiNivelHabilidadePentear.clear();
            paiEmocao.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Pai no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Nível de Habilidade deve ser um número válido.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarTutorialVideo() {
        String titulo = tutorialVideoTitulo.getText();
        int duracao = Integer.parseInt(tutorialVideoDuracao.getText());
        String autor = tutorialVideoAutor.getText();

        TutorialVideo novoTutorialVideo = new TutorialVideo(titulo, duracao, autor);

        try {
            registroDAO.salvar(novoTutorialVideo);
            tutorialVideoTitulo.clear();
            tutorialVideoDuracao.clear();
            tutorialVideoAutor.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Tutorial de Vídeo no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Duração deve ser um número válido.");
            e.printStackTrace();
        }
    }

    @FXML
    private void goBackToMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/lp1_e1/Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
