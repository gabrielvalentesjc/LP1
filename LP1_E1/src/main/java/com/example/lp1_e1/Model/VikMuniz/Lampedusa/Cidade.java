package com.example.lp1_e1.Model.VikMuniz.Lampedusa;

import com.example.lp1_e1.Model.Registravel;

public class Cidade implements Registravel {
    private String nome;
    private Double territorio;
    private Double altitude;

    public Cidade(String nome, Double territorio, Double altitude) {
        this.nome = nome;
        this.territorio = territorio;
        this.altitude = altitude;
    }

    public String getNome() {
        return nome;
    }

    public Double getTerritorio() {
        return territorio;
    }

    public Double getAltitude() {
        return altitude;
    }

    @Override
    public String toCsvRow() {
        return nome + "," + territorio + "," + altitude;
    }

    @Override
    public String getCsvHeader() {
        return "nome,territorio,altitude";
    }

    public void abrigarPessoas() {
        System.out.println("A cidade esta abrigando pessoas");
    }
}
