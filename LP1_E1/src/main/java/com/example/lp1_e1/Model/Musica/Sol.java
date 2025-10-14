package com.example.lp1_e1.Model.Musica;

import com.example.lp1_e1.Model.Registravel;

public class Sol implements Registravel {
    private String intensidade;
    private String posicao;
    private String temperatura;

    public Sol(String intensidade, String posicao, String temperatura) {
        this.intensidade = intensidade;
        this.posicao = posicao;
        this.temperatura = temperatura;
    }

    public String getIntensidade() {
        return intensidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    @Override
    public String toCsvRow() {
        return intensidade + "," + posicao + "," + temperatura;
    }

    @Override
    public String getCsvHeader() {
        return "intensidade,posicao,temperatura";
    }

    public void brilhar() {
        System.out.println("O sol está brilhando.");
    }

    public void aquecer() {
        System.out.println("O sol está aquecendo.");
    }

    public void nascer() {
        System.out.println("O sol está nascendo.");
    }
}
