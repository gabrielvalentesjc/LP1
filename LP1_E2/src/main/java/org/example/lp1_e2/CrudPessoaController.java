package org.example.lp1_e2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.lp1_e2.DAO.MusicaDAO;
import org.example.lp1_e2.Model.Pessoa;

import java.io.IOException;

public class CrudPessoaController {

    @FXML private TableView<Pessoa> tabelaPessoa;
    @FXML private TableColumn<Pessoa, Integer> colId;
    @FXML private TableColumn<Pessoa, String> colNome;
    @FXML private TableColumn<Pessoa, String> colHumor;
    @FXML private TableColumn<Pessoa, String> colObjetivo;

    @FXML private TextField tfId;
    @FXML private TextField tfNome;
    @FXML private TextField tfHumor;
    @FXML private TextField tfObjetivo;

    private final MusicaDAO dao = new MusicaDAO();

    @FXML
    public void initialize() {
        // Configurar colunas da tabela para ler os atributos da classe Pessoa
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colHumor.setCellValueFactory(new PropertyValueFactory<>("humor"));
        colObjetivo.setCellValueFactory(new PropertyValueFactory<>("objetivo"));

        // Carregar dados
        atualizarTabela();

        // Adicionar evento de clique na tabela para preencher os campos
        tabelaPessoa.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                preencherCampos(newSelection);
            }
        });
    }

    private void atualizarTabela() {
        ObservableList<Pessoa> lista = FXCollections.observableArrayList(dao.listarPessoas());
        tabelaPessoa.setItems(lista);
    }

    private void preencherCampos(Pessoa p) {
        tfId.setText(String.valueOf(p.getId()));
        tfNome.setText(p.getNome());
        tfHumor.setText(p.getHumor());
        tfObjetivo.setText(p.getObjetivo());
    }

    @FXML
    private void limparCampos() {
        tfId.clear();
        tfNome.clear();
        tfHumor.clear();
        tfObjetivo.clear();
        tabelaPessoa.getSelectionModel().clearSelection();
    }

    @FXML
    private void salvar() {
        Pessoa p = new Pessoa(tfNome.getText(), tfHumor.getText(), tfObjetivo.getText());
        dao.salvarPessoa(p);
        atualizarTabela();
        limparCampos();
    }

    @FXML
    private void atualizar() {
        if (tfId.getText().isEmpty()) {
            showAlert("Selecione um registro na tabela para atualizar.");
            return;
        }
        int id = Integer.parseInt(tfId.getText());
        Pessoa p = new Pessoa(tfNome.getText(), tfHumor.getText(), tfObjetivo.getText());
        p.setId(id);

        dao.atualizarPessoa(p);
        atualizarTabela();
        limparCampos();
    }

    @FXML
    private void deletar() {
        if (tfId.getText().isEmpty()) {
            showAlert("Selecione um registro na tabela para deletar.");
            return;
        }
        int id = Integer.parseInt(tfId.getText());
        dao.deletarPessoa(id);
        atualizarTabela();
        limparCampos();
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/lp1_e2/MusicaMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}