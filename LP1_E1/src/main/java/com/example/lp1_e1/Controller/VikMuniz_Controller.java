package com.example.lp1_e1.Controller;

import com.example.lp1_e1.DAO.RegistroDAO;
import com.example.lp1_e1.Model.VikMuniz.Lampedusa.Barco;
import com.example.lp1_e1.Model.VikMuniz.Lampedusa.Cidade;
import com.example.lp1_e1.Model.VikMuniz.Lampedusa.Rio;
import com.example.lp1_e1.Model.VikMuniz.JohnLennon.Cafe;
import com.example.lp1_e1.Model.VikMuniz.JohnLennon.Caneca;
import com.example.lp1_e1.Model.VikMuniz.JohnLennon.Cantor;
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

public class VikMuniz_Controller {
    // ============ ABA VIK MUNIZ - LAMPEDUSA ============
    @FXML private TextField barcoModelo;
    @FXML private TextField barcoMaterial;
    @FXML private TextField barcoTamanho;

    @FXML private TextField cidadeNome;
    @FXML private TextField cidadeTerritorio;
    @FXML private TextField cidadeAltitude;

    @FXML private TextField rioNome;
    @FXML private TextField rioExtensao;
    @FXML private TextField rioTemperatura;

    // ============ ABA VIK MUNIZ - JOHN LENNON ============
    @FXML private TextField cantorNome;
    @FXML private TextField cantorIdade;
    @FXML private TextField cantorEstilo;

    @FXML private TextField cafeOrigem;
    @FXML private TextField cafeAroma;
    @FXML private TextField cafeNotas;

    @FXML private TextField canecaCor;
    @FXML private TextField canecaCapacidade;
    @FXML private TextField canecaMaterial;

    private final RegistroDAO registroDAO = new RegistroDAO();

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void criarBarco() {
        String modelo = barcoModelo.getText();
        String material = barcoMaterial.getText();
        String tamanho = barcoTamanho.getText();

        Barco novoBarco = new Barco(modelo, material, tamanho);

        try {
            registroDAO.salvar(novoBarco);
            barcoModelo.clear();
            barcoMaterial.clear();
            barcoTamanho.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Barco no arquivo.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarCidade() {
        String nome = cidadeNome.getText();
        Double territorio = Double.parseDouble(cidadeTerritorio.getText());
        Double altitude = Double.parseDouble(cidadeAltitude.getText());

        Cidade novaCidade = new Cidade(nome, territorio, altitude);

        try {
            registroDAO.salvar(novaCidade);
            cidadeNome.clear();
            cidadeTerritorio.clear();
            cidadeAltitude.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados da Cidade no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Território e Altitude devem ser números válidos.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarRio() {
        String nome = rioNome.getText();
        Double extensao = Double.parseDouble(rioExtensao.getText());
        Double temperatura = Double.parseDouble(rioTemperatura.getText());

        Rio novoRio = new Rio(nome, extensao, temperatura);

        try {
            registroDAO.salvar(novoRio);
            rioNome.clear();
            rioExtensao.clear();
            rioTemperatura.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Rio no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Extensão e Temperatura devem ser números válidos.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarCantor() {
        String nome = cantorNome.getText();
        Integer idade = Integer.parseInt(cantorIdade.getText());
        String estilo = cantorEstilo.getText();

        Cantor novoCantor = new Cantor(nome, idade, estilo);

        try {
            registroDAO.salvar(novoCantor);
            cantorNome.clear();
            cantorIdade.clear();
            cantorEstilo.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Cantor no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Idade deve ser um número válido.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarCafe() {
        String origem = cafeOrigem.getText();
        String aroma = cafeAroma.getText();
        String notas = cafeNotas.getText();

        Cafe novoCafe = new Cafe(origem, aroma, notas);

        try {
            registroDAO.salvar(novoCafe);
            cafeOrigem.clear();
            cafeAroma.clear();
            cafeNotas.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Café no arquivo.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarCaneca() {
        String cor = canecaCor.getText();
        Double capacidade = Double.parseDouble(canecaCapacidade.getText());
        String material = canecaMaterial.getText();

        Caneca novaCaneca = new Caneca(cor, capacidade, material);

        try {
            registroDAO.salvar(novaCaneca);
            canecaCor.clear();
            canecaCapacidade.clear();
            canecaMaterial.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados da Caneca no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Capacidade deve ser um número válido.");
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
