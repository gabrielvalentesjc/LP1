package com.example.lp1_e1.Model.VikMuniz.JohnLennon;

import com.example.lp1_e1.Model.Registravel;

public class Cafe implements Registravel {
    private String origem;
    private String aroma;
    private String notas;

    public Cafe(String origem, String aroma, String notas) {
        this.origem = origem;
        this.aroma = aroma;
        this.notas = notas;
    }

    public String getOrigem() {
        return origem;
    }

    public String getAroma() {
        return aroma;
    }

    public String getNotas() {
        return notas;
    }

    @Override
    public String toCsvRow() {
        return origem + "," + aroma + "," + notas;
    }

    @Override
    public String getCsvHeader() {
        return "origem,aroma,notas";
    }

    public void darEnergia() {
        System.out.println("O café esta dando energia");
    }
}
