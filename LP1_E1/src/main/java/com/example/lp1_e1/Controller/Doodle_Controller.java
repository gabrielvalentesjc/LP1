package com.example.lp1_e1.Controller;

import com.example.lp1_e1.DAO.RegistroDAO;
import com.example.lp1_e1.Model.Doodle.Animal;
import com.example.lp1_e1.Model.Doodle.Casa;
import com.example.lp1_e1.Model.Doodle.Veiculo;
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

public class Doodle_Controller {

    // ============  DOODLE - ANIMAL ============
    @FXML private TextField animalEspecie;
    @FXML private TextField animalIdade;
    @FXML private TextField animalPeso;

    // ============  DOODLE - CASA ============
    @FXML private TextField casaEndereco;
    @FXML private TextField casaCor;
    @FXML private TextField casaTamanho;

    // ============  DOODLE - VEICULO ============
    @FXML private TextField veiculoNome;
    @FXML private TextField veiculoCategoria;
    @FXML private TextField veiculoMarca;

    private final RegistroDAO registroDAO = new RegistroDAO();

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void criarAnimal() {
        String especie = animalEspecie.getText();
        int idade = Integer.parseInt(animalIdade.getText());
        double peso = Double.parseDouble(animalPeso.getText());

        Animal novoAnimal = new Animal(especie, idade, peso);

        try {
            registroDAO.salvar(novoAnimal);
            animalEspecie.clear();
            animalIdade.clear();
            animalPeso.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Animal no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Idade e Peso devem ser números válidos.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarCasa() {
        String endereco = casaEndereco.getText();
        String cor = casaCor.getText();
        double tamanho = Double.parseDouble(casaTamanho.getText());

        Casa novaCasa = new Casa(endereco, cor, tamanho);

        try {
            registroDAO.salvar(novaCasa);
            casaEndereco.clear();
            casaCor.clear();
            casaTamanho.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados da Casa no arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Tamanho deve ser um número válido.");
            e.printStackTrace();
        }
    }

    @FXML
    private void criarVeiculo() {
        String nome = veiculoNome.getText();
        String categoria = veiculoCategoria.getText();
        String marca = veiculoMarca.getText();

        Veiculo novoVeiculo = new Veiculo(nome, categoria, marca);

        try {
            registroDAO.salvar(novoVeiculo);
            veiculoNome.clear();
            veiculoCategoria.clear();
            veiculoMarca.clear();
        } catch (IOException e) {
            showAlert("Erro de Gravação", "Não foi possível salvar os dados do Veículo no arquivo.");
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
