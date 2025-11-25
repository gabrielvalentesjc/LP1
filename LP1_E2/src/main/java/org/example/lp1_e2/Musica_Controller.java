package org.example.lp1_e2;

import org.example.lp1_e2.DAO.MusicaDAO; // Importe o novo DAO
import org.example.lp1_e2.Model.Dia;
import org.example.lp1_e2.Model.Pessoa;
import org.example.lp1_e2.Model.Sol;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class Musica_Controller {
    // ... (Seus campos @FXML continuam iguais) ...
    @FXML private TextField pessoaId;
    @FXML private TextField pessoaNome;
    @FXML private TextField pessoaHumor;
    @FXML private TextField pessoaObjetivo;

    @FXML private TextField solId;
    @FXML private TextField solIntensidade;
    @FXML private TextField solPosicao;
    @FXML private TextField solTemperatura;

    @FXML private TextField diaId;
    @FXML private TextField diaPeriodo;
    @FXML private TextField diaClima;
    @FXML private TextField diaEvento;

    // TROCA: De RegistroDAO para MusicaDAO
    private final MusicaDAO musicaDAO = new MusicaDAO();

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR); // Pode mudar para INFORMATION se for sucesso
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Método auxiliar para msg de sucesso
    private void showSuccess(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void criarPessoa() {
        String nome = pessoaNome.getText();
        String humor = pessoaHumor.getText();
        String objetivo = pessoaObjetivo.getText();

        Pessoa novaPessoa = new Pessoa(nome, humor, objetivo);

        try {
            // Chama o DAO do Banco de Dados
            musicaDAO.salvarPessoa(novaPessoa);

            showSuccess("Sucesso", "Pessoa salva no Banco de Dados!");

            pessoaNome.clear();
            pessoaHumor.clear();
            pessoaObjetivo.clear();
        } catch (Exception e) {
            showAlert("Erro de Gravação", "Não foi possível salvar no banco: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void criarSol() {
        String intensidade = solIntensidade.getText();
        String posicao = solPosicao.getText();
        String temperatura = solTemperatura.getText();

        Sol novoSol = new Sol(intensidade, posicao, temperatura);

        try {
            musicaDAO.salvarSol(novoSol);
            showSuccess("Sucesso", "Sol salvo no Banco de Dados!");

            solIntensidade.clear();
            solPosicao.clear();
            solTemperatura.clear();
        } catch (Exception e) {
            showAlert("Erro de Gravação", "Erro ao salvar Sol: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void criarDia() {
        String periodo = diaPeriodo.getText();
        String clima = diaClima.getText();
        String evento = diaEvento.getText();

        Dia novoDia = new Dia(periodo, clima, evento);

        try {
            musicaDAO.salvarDia(novoDia); //
            showSuccess("Sucesso", "Dia salvo no Banco de Dados!");

            diaPeriodo.clear();
            diaClima.clear();
            diaEvento.clear();
        } catch (Exception e) {
            showAlert("Erro de Gravação", "Erro ao salvar Dia: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void goBackToMain(ActionEvent event) throws IOException {
        // ATENÇÃO AQUI: Ajuste o caminho para combinar com sua pasta resources
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/lp1_e2/Main-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void deletarPessoa() {
        try {
            int id = Integer.parseInt(pessoaId.getText());
            musicaDAO.deletarPessoa(id);
            showSuccess("Sucesso", "Pessoa deletada!");
            pessoaId.clear();
        } catch (NumberFormatException e) {
            showAlert("Erro", "Digite um ID válido para deletar.");
        }
    }

    @FXML
    private void atualizarPessoa() {
        try {
            int id = Integer.parseInt(pessoaId.getText());

            // Cria objeto com os dados novos dos campos de texto
            Pessoa p = new Pessoa(pessoaNome.getText(), pessoaHumor.getText(), pessoaObjetivo.getText());
            p.setId(id); // Define qual ID será alterado

            musicaDAO.atualizarPessoa(p);
            showSuccess("Sucesso", "Dados atualizados!");

        } catch (Exception e) {
            showAlert("Erro", "Falha ao atualizar.");
        }
    }

    @FXML
    private void atualizarSol() {
        try {
            int id = Integer.parseInt(solId.getText());
            Sol s = new Sol(solIntensidade.getText(), solPosicao.getText(), solTemperatura.getText());
            s.setId(id);
            musicaDAO.atualizarSol(s); // Certifique-se que esse método existe no DAO
            showSuccess("Sucesso", "Sol atualizado!");
        } catch (Exception e) {
            showAlert("Erro", "Erro ao atualizar Sol.");
        }
    }

    @FXML
    private void deletarSol() {
        try {
            int id = Integer.parseInt(solId.getText());
            musicaDAO.deletarSol(id); // Certifique-se que esse método existe no DAO
            showSuccess("Sucesso", "Sol deletado!");
            solId.clear();
        } catch (Exception e) {
            showAlert("Erro", "Erro ao deletar Sol.");
        }
    }

    @FXML
    private void deletarDia() {
        try {
            int id = Integer.parseInt(diaId.getText());
            musicaDAO.deletarDia(id);
            showSuccess("Sucesso", "Dia deletado!");
            diaId.clear();
        } catch (NumberFormatException e) {
            showAlert("Erro", "Digite um ID válido para deletar.");
        } catch (Exception e) {
            showAlert("Erro", "Erro ao deletar Dia: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void atualizarDia() {
        try {
            int id = Integer.parseInt(diaId.getText());

            // 1. Cria o objeto com os novos dados dos campos de texto
            Dia diaAtualizado = new Dia(diaPeriodo.getText(), diaClima.getText(), diaEvento.getText());

            // 2. Define o ID para que o banco saiba qual registro alterar
            diaAtualizado.setId(id);

            // 3. Chama o DAO
            musicaDAO.atualizarDia(diaAtualizado);

            showSuccess("Sucesso", "Dia atualizado com sucesso!");

        } catch (NumberFormatException e) {
            showAlert("Erro", "Digite um ID válido para atualizar.");
        } catch (Exception e) {
            showAlert("Erro", "Erro ao atualizar Dia: " + e.getMessage());
            e.printStackTrace();
        }
    }
}