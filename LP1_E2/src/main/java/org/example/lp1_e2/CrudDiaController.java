package org.example.lp1_e2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.lp1_e2.DAO.MusicaDAO;
import org.example.lp1_e2.Model.Dia;
import java.io.IOException;

public class CrudDiaController {
    @FXML private TableView<Dia> tabelaDia;
    @FXML private TableColumn<Dia, Integer> colId;
    @FXML private TableColumn<Dia, String> colPeriodo;
    @FXML private TableColumn<Dia, String> colClima;
    @FXML private TableColumn<Dia, String> colEvento;

    @FXML private TextField tfId;
    @FXML private TextField tfPeriodo;
    @FXML private TextField tfClima;
    @FXML private TextField tfEvento;

    private final MusicaDAO dao = new MusicaDAO();

    @FXML public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPeriodo.setCellValueFactory(new PropertyValueFactory<>("periodo"));
        colClima.setCellValueFactory(new PropertyValueFactory<>("clima"));
        colEvento.setCellValueFactory(new PropertyValueFactory<>("evento"));

        atualizarTabela();

        tabelaDia.getSelectionModel().selectedItemProperty().addListener((obs, old, novo) -> {
            if (novo != null) {
                tfId.setText(String.valueOf(novo.getId()));
                tfPeriodo.setText(novo.getPeriodo());
                tfClima.setText(novo.getClima());
                tfEvento.setText(novo.getEvento());
            }
        });
    }

    private void atualizarTabela() {
        tabelaDia.setItems(FXCollections.observableArrayList(dao.listarDias()));
    }

    @FXML private void limparCampos() {
        tfId.clear(); tfPeriodo.clear(); tfClima.clear(); tfEvento.clear();
        tabelaDia.getSelectionModel().clearSelection();
    }

    @FXML private void salvar() {
        Dia d = new Dia(tfPeriodo.getText(), tfClima.getText(), tfEvento.getText());
        dao.salvarDia(d);
        atualizarTabela(); limparCampos();
    }

    @FXML private void atualizar() {
        if(tfId.getText().isEmpty()) return;
        Dia d = new Dia(tfPeriodo.getText(), tfClima.getText(), tfEvento.getText());
        d.setId(Integer.parseInt(tfId.getText()));
        dao.atualizarDia(d);
        atualizarTabela(); limparCampos();
    }

    @FXML private void deletar() {
        if(tfId.getText().isEmpty()) return;
        dao.deletarDia(Integer.parseInt(tfId.getText()));
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