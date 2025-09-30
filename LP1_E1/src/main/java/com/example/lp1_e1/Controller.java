package com.example.lp1_e1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private TextField txtP1;
    @FXML private TextField txtE1;
    @FXML private TextField txtE2;
    @FXML private TextField txtX;
    @FXML private TextField txtSub;
    @FXML private TextField txtApi;
    @FXML private Label lblResultado;
    @FXML private Button btnCalcular;
    @FXML private Button btnLimpar;

    private CalculoMedia calculo = new CalculoMedia();

    @FXML
    private void calcularMedia() {
        try {
            double p1  = Double.parseDouble(txtP1.getText());
            double e1  = Double.parseDouble(txtE1.getText());
            double e2  = Double.parseDouble(txtE2.getText());
            double x   = Double.parseDouble(txtX.getText());
            double sub = Double.parseDouble(txtSub.getText());
            double api = Double.parseDouble(txtApi.getText());

            // envia para a lógica
            calculo.setNotas(p1, e1, e2, x, sub, api);

            double media = calculo.calcularMedia();
            lblResultado.setText("Sua média final é: " + String.format("%.2f", media));

        } catch (NumberFormatException e) {
            lblResultado.setText("Erro: Digite apenas números válidos!");
        }
    }

    @FXML
    private void limparCampos() {
        txtP1.clear();
        txtE1.clear();
        txtE2.clear();
        txtX.clear();
        txtSub.clear();
        txtApi.clear();
        lblResultado.setText("");
    }
    // ----------- MÚSICA -----------
    @FXML private Button btnProcurarLuz;
    @FXML private Button btnBrilhar;
    @FXML private Button btnTranscorrer;
    @FXML private Label lblMusica1;
    @FXML private Label lblMusica2;
    @FXML private Label lblMusica3;

    @FXML
    private void procurarLuz() {
        lblMusica1.setText("Procurando a luz...");
    }

    @FXML
    private void brilhar() {
        lblMusica2.setText("O sol brilhou ☀️");
    }

    @FXML
    private void transcorrer() {
        lblMusica3.setText("O dia transcorreu 🌅");
    }

    // ----------- VIK MUNIZ -----------
    @FXML private Button btnDarEnergia;
    @FXML private Button btnCantar;
    @FXML private Button btnArmazenarBebida;
    @FXML private Button btnAbrigarPessoas;
    @FXML private Button btnNavegar;
    @FXML private Button btnAbastecer;
    @FXML private Label lblVik1;
    @FXML private Label lblVik2;
    @FXML private Label lblVik3;

    @FXML
    private void darEnergia() {
        lblVik1.setText("Energia dada ⚡");
    }

    @FXML
    private void cantar() {
        lblVik2.setText("John começou a cantar 🎤");
    }

    @FXML
    private void armazenarBebida() {
        lblVik3.setText("Bebida armazenada 🍵");
    }

    @FXML
    private void abrigarPessoas() {
        lblVik1.setText("Abrigando pessoas 🏠");
    }

    @FXML
    private void navegar() {
        lblVik2.setText("Navegando 🚤");
    }

    @FXML
    private void abastecer() {
        lblVik3.setText("Abastecido ⛽");
    }

    // ----------- DOODLE -----------
    @FXML private Button btnComer;
    @FXML private Button btnAbrirPorta;
    @FXML private Button btnFreiar;
    @FXML private Button btnFazerBarulho;
    @FXML private Button btnDormir;
    @FXML private Button btnFecharPorta;
    @FXML private Button btnEntrar;
    @FXML private Button btnAndar;
    @FXML private Button btnBuzinar;
    @FXML private Label lblDoodle1;
    @FXML private Label lblDoodle2;
    @FXML private Label lblDoodle3;

    @FXML
    private void comer() {
        lblDoodle1.setText("O animal comeu 🍖");
    }

    @FXML
    private void abrirPorta() {
        lblDoodle2.setText("A porta abriu 🚪");
    }

    @FXML
    private void freiar() {
        lblDoodle3.setText("O veículo freiou 🚗💨");
    }

    @FXML
    private void fazerBarulho() {
        lblDoodle1.setText("Barulho feito 🔊");
    }

    @FXML
    private void dormir() {
        lblDoodle2.setText("Dormindo 😴");
    }

    @FXML
    private void fecharPorta() {
        lblDoodle3.setText("Porta fechada 🔒");
    }

    @FXML
    private void entrar() {
        lblDoodle1.setText("Entrou 🏠");
    }

    @FXML
    private void andar() {
        lblDoodle2.setText("Andando 🚶");
    }

    @FXML
    private void buzinar() {
        lblDoodle3.setText("Buzinou 📯");
    }

    // ----------- VÍDEO -----------
    @FXML private Button btnMostrarTutorial;
    @FXML private Button btnPentear;
    @FXML private Button btnExecutar;
    @FXML private Label lblVideo1;
    @FXML private Label lblVideo2;
    @FXML private Label lblVideo3;

    @FXML
    private void mostrarTutorialAoPai() {
        lblVideo1.setText("Tutorial exibido 📹");
    }

    @FXML
    private void tentarPentear() {
        lblVideo2.setText("Tentando pentear 👧➡️👱‍♂️");
    }

    @FXML
    private void executar() {
        lblVideo3.setText("Execução concluída ✅");
    }
}
