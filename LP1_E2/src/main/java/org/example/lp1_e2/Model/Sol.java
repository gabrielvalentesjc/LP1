package org.example.lp1_e2.Model;

public class Sol {
    private int id; // Novo atributo
    private String intensidade;
    private String posicao;
    private String temperatura;

    // Construtor vazio
    public Sol() {
    }

    public Sol(String intensidade, String posicao, String temperatura) {
        this.intensidade = intensidade;
        this.posicao = posicao;
        this.temperatura = temperatura;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    // Métodos da lógica original
    public void brilhar() {
        System.out.println("O sol está brilhando.");
    }

    public void aquecer() {
        System.out.println("O sol está aquecendo.");
    }

    public void nascer() {
        System.out.println("O sol está nascendo.");
    }

    public String toCsvRow() {
        return intensidade + "," + posicao + "," + temperatura;
    }

    public String getCsvHeader() {
        return "intensidade,posicao,temperatura";
    }
}