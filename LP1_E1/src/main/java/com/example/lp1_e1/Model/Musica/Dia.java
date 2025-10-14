package com.example.lp1_e1.Model.Musica;

import com.example.lp1_e1.Model.Registravel;

public class Dia implements Registravel {
    private String periodo;
    private String clima;
    private String evento;

    public Dia(String periodo, String clima, String evento) {
        this.periodo = periodo;
        this.clima = clima;
        this.evento = evento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getClima() {
        return clima;
    }

    public String getEvento() {
        return evento;
    }

    @Override
    public String toCsvRow() {
        return periodo + "," + clima + "," + evento;
    }

    @Override
    public String getCsvHeader() {
        return "periodo,clima,evento";
    }

    public void amanhecer() {
        System.out.println("O dia está amanhecendo.");
    }

    public void entardecer() {
        System.out.println("O dia está entardecendo.");
    }

    public void anoitecer() {
        System.out.println("O dia está anoitecendo.");
    }
}
