package com.example.lp1_e1.Model.VikMuniz.JohnLennon;

import com.example.lp1_e1.Model.Registravel;

public class Cantor implements Registravel {
    private String modelo;
    private Integer idade;
    private String estilo;

    public Cantor(String modelo, Integer idade, String estilo) {
        this.modelo = modelo;
        this.idade = idade;
        this.estilo = estilo;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getEstilo() {
        return estilo;
    }

    @Override
    public String toCsvRow() {
        return modelo + "," + idade + "," + estilo;
    }

    @Override
    public String getCsvHeader() {
        return "modelo,idade,estilo";
    }

    public void cantar() {
        System.out.println("O cantor esta cantando");
    }
}
