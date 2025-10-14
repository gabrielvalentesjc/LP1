package com.example.lp1_e1.Model.VikMuniz.JohnLennon;

import com.example.lp1_e1.Model.Registravel;

public class Caneca implements Registravel {
    private String cor;
    private Double capacidade;
    private String material;

    public Caneca(String cor, Double capacidade, String material) {
        this.cor = cor;
        this.capacidade = capacidade;
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toCsvRow() {
        return cor + "," + capacidade + "," + material;
    }

    @Override
    public String getCsvHeader() {
        return "cor,capacidade,material";
    }

    public void armazenarBebida() {System.out.println("A caneca esta armazenando bebida");
    }
}
