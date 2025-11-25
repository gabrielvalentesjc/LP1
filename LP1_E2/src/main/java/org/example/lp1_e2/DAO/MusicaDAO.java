package org.example.lp1_e2.DAO;

import org.example.lp1_e2.Model.Dia;
import org.example.lp1_e2.Model.Pessoa;
import org.example.lp1_e2.Model.Sol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    // ========================================================================
    //                                  PESSOA
    // ========================================================================

    // 1. CREATE (Salvar Pessoa)
    public void salvarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, humor, objetivo) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getHumor());
            stmt.setString(3, pessoa.getObjetivo());

            stmt.executeUpdate();
            System.out.println("Pessoa salva com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar Pessoa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 2. READ (Listar Pessoas)
    public List<Pessoa> listarPessoas() {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setHumor(rs.getString("humor"));
                p.setObjetivo(rs.getString("objetivo"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Pessoas: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    // 3. UPDATE (Atualizar Pessoa)
    public void atualizarPessoa(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, humor = ?, objetivo = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getHumor());
            stmt.setString(3, pessoa.getObjetivo());
            stmt.setInt(4, pessoa.getId());

            stmt.executeUpdate();
            System.out.println("Pessoa atualizada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Pessoa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 4. DELETE (Deletar Pessoa)
    public void deletarPessoa(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pessoa deletada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Pessoa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ========================================================================
    //                                    SOL
    // ========================================================================

    // 5. CREATE (Salvar Sol)
    public void salvarSol(Sol sol) {
        String sql = "INSERT INTO sol (intensidade, posicao, temperatura) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sol.getIntensidade());
            stmt.setString(2, sol.getPosicao());
            stmt.setString(3, sol.getTemperatura());

            stmt.executeUpdate();
            System.out.println("Sol salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar Sol: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 6. READ (Listar Sol)
    public List<Sol> listarSol() {
        List<Sol> lista = new ArrayList<>();
        String sql = "SELECT * FROM sol";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Supondo construtor vazio ou setters. Ajuste conforme sua classe Sol.
                Sol s = new Sol(rs.getString("intensidade"), rs.getString("posicao"), rs.getString("temperatura"));
                s.setId(rs.getInt("id")); // Importante ter setId na classe Sol
                lista.add(s);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Sol: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    // 7. UPDATE (Atualizar Sol)
    public void atualizarSol(Sol sol) {
        String sql = "UPDATE sol SET intensidade = ?, posicao = ?, temperatura = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sol.getIntensidade());
            stmt.setString(2, sol.getPosicao());
            stmt.setString(3, sol.getTemperatura());
            stmt.setInt(4, sol.getId());

            stmt.executeUpdate();
            System.out.println("Sol atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Sol: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 8. DELETE (Deletar Sol)
    public void deletarSol(int id) {
        String sql = "DELETE FROM sol WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Sol deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Sol: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ========================================================================
    //                                    DIA
    // ========================================================================

    // 9. CREATE (Salvar Dia)
    public void salvarDia(Dia dia) {
        String sql = "INSERT INTO dia (periodo, clima, evento) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dia.getPeriodo());
            stmt.setString(2, dia.getClima());
            stmt.setString(3, dia.getEvento());

            stmt.executeUpdate();
            System.out.println("Dia salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar Dia: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 10. READ (Listar Dias)
    public List<Dia> listarDias() {
        List<Dia> lista = new ArrayList<>();
        String sql = "SELECT * FROM dia";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Ajuste conforme construtor da classe Dia
                Dia d = new Dia(rs.getString("periodo"), rs.getString("clima"), rs.getString("evento"));
                d.setId(rs.getInt("id")); // Importante ter setId na classe Dia
                lista.add(d);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Dias: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    // 11. UPDATE (Atualizar Dia)
    public void atualizarDia(Dia dia) {
        String sql = "UPDATE dia SET periodo = ?, clima = ?, evento = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dia.getPeriodo());
            stmt.setString(2, dia.getClima());
            stmt.setString(3, dia.getEvento());
            stmt.setInt(4, dia.getId());

            stmt.executeUpdate();
            System.out.println("Dia atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Dia: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 12. DELETE (Deletar Dia)
    public void deletarDia(int id) {
        String sql = "DELETE FROM dia WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Dia deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Dia: " + e.getMessage());
            e.printStackTrace();
        }
    }
}