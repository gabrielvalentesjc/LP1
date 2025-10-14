package com.example.lp1_e1.Controller;

import com.example.lp1_e1.DAO.RegistroDAO;
import com.example.lp1_e1.Model.Musica.Dia;
import com.example.lp1_e1.Model.Musica.Pessoa;
import com.example.lp1_e1.Model.Musica.Sol;
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

public class Musica_Controller {
    // ============  MÚSICA - PESSOA ============
    @FXML private TextField pessoaNome;
    @FXML private TextField pessoaHumor;
    @FXML private TextField pessoaObjetivo;

    // ============  MÚSICA - SOL ============
    @FXML private TextField solIntensidade;
    @FXML private TextField solPosicao;
    @FXML private TextField solTemperatura;

    // ============  MÚSICA - DIA ============
    @FXML private TextField diaPeriodo;
    @FXML private TextField diaClima;
    @FXML private TextField diaEvento;

    private final RegistroDAO registroDAO = new RegistroDAO();

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void criarPessoa() {
        // 1. Coleta os dados da View
        String nome = pessoaNome.getText();
        String humor = pessoaHumor.getText();
        String objetivo = pessoaObjetivo.getText();

        // 2. Cria um objeto do Model
        Pessoa novaPessoa = new Pessoa(nome, humor, objetivo);

        // 3. Usa o DAO para persistir o objeto
        try {
            registroDAO.salvar(novaPessoa);
            // 4. Limpa a View após o sucesso
            pessoaNome.clear();
            pessoaHumor.clear();
            pessoaObjetivo.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados da Pessoa no arquivo.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarSol() {
        String intensidade = solIntensidade.getText();
        String posicao = solPosicao.getText();
        String temperatura = solTemperatura.getText();

        Sol novoSol = new Sol(intensidade, posicao, temperatura); // Assumindo que Sol foi corrigido

        try {
            registroDAO.salvar(novoSol);
            solIntensidade.clear();
            solPosicao.clear();
            solTemperatura.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Sol no arquivo.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarDia() {
        String periodo = diaPeriodo.getText();
        String clima = diaClima.getText();
        String evento = diaEvento.getText();

        Dia novoDia = new Dia(periodo, clima, evento); // Assumindo que Dia foi corrigido

        try {
            registroDAO.salvar(novoDia);
            diaPeriodo.clear();
            diaClima.clear();
            diaEvento.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Dia no arquivo.");
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