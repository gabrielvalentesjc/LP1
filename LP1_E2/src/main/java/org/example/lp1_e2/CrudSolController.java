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
import org.example.lp1_e2.Model.Sol;
import java.io.IOException;

public class CrudSolController {
    @FXML private TableView<Sol> tabelaSol;
    @FXML private TableColumn<Sol, Integer> colId;
    @FXML private TableColumn<Sol, String> colIntensidade;
    @FXML private TableColumn<Sol, String> colPosicao;
    @FXML private TableColumn<Sol, String> colTemperatura;

    @FXML private TextField tfId;
    @FXML private TextField tfIntensidade;
    @FXML private TextField tfPosicao;
    @FXML private TextField tfTemperatura;

    private final MusicaDAO dao = new MusicaDAO();

    @FXML public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colIntensidade.setCellValueFactory(new PropertyValueFactory<>("intensidade"));
        colPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));
        colTemperatura.setCellValueFactory(new PropertyValueFactory<>("temperatura"));

        atualizarTabela();

        tabelaSol.getSelectionModel().selectedItemProperty().addListener((obs, old, novo) -> {
            if (novo != null) {
                tfId.setText(String.valueOf(novo.getId()));
                tfIntensidade.setText(novo.getIntensidade());
                tfPosicao.setText(novo.getPosicao());
                tfTemperatura.setText(novo.getTemperatura());
            }
        });
    }

    private void atualizarTabela() {
        tabelaSol.setItems(FXCollections.observableArrayList(dao.listarSol()));
    }

    @FXML private void limparCampos() {
        tfId.clear(); tfIntensidade.clear(); tfPosicao.clear(); tfTemperatura.clear();
        tabelaSol.getSelectionModel().clearSelection();
    }

    @FXML private void salvar() {
        Sol s = new Sol(tfIntensidade.getText(), tfPosicao.getText(), tfTemperatura.getText());
        dao.salvarSol(s);
        atualizarTabela(); limparCampos();
    }

    @FXML private void atualizar() {
        if(tfId.getText().isEmpty()) return;
        Sol s = new Sol(tfIntensidade.getText(), tfPosicao.getText(), tfTemperatura.getText());
        s.setId(Integer.parseInt(tfId.getText()));
        dao.atualizarSol(s);
        atualizarTabela(); limparCampos();
    }

    @FXML private void deletar() {
        if(tfId.getText().isEmpty()) return;
        dao.deletarSol(Integer.parseInt(tfId.getText()));
        atualizarTabela(); limparCampos();
    }

    @FXML private void voltar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/lp1_e2/MusicaMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}