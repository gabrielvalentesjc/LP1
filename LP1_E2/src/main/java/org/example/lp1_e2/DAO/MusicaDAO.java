package org.example.lp1_e2.DAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.lp1_e2.Model.Dia;
import org.example.lp1_e2.Model.Pessoa;
import org.example.lp1_e2.Model.Sol;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MusicaDAO {

    // ============ CRUD PESSOA ============
    public void salvarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, humor, objetivo) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getHumor());
            stmt.setString(3, pessoa.getObjetivo());

            stmt.executeUpdate();
            System.out.println("Pessoa salva no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar Pessoa: " + e.getMessage());
        }
    }

    // ============ CRUD SOL ============
    public void salvarSol(Sol sol) {
        String sql = "INSERT INTO sol (intensidade, posicao, temperatura) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sol.getIntensidade());
            stmt.setString(2, sol.getPosicao());
            stmt.setString(3, sol.getTemperatura());

            stmt.executeUpdate();
            System.out.println("Sol salvo no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar Sol: " + e.getMessage());
        }
    }

    // ============ CRUD DIA ============
    public void salvarDia(Dia dia) {
        String sql = "INSERT INTO dia (periodo, clima, evento) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dia.getPeriodo());
            stmt.setString(2, dia.getClima());
            stmt.setString(3, dia.getEvento());

            stmt.executeUpdate();
            System.out.println("Dia salvo no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar Dia: " + e.getMessage());
        }
    }

    public void goBackToMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/lp1_e2/Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Obs: Para completar o CRUD (Read, Update, Delete), você adicionaria métodos como:
    // public List<Pessoa> listarPessoas() { ... SELECT * FROM pessoa ... }
    // public void atualizarPessoa(Pessoa p) { ... UPDATE pessoa SET ... }
    // public void deletarPessoa(int id) { ... DELETE FROM pessoa ... }
}