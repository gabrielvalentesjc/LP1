package com.example.lp1_e1.Model.Musica;

import com.example.lp1_e1.Model.Registravel;

public class Pessoa implements Registravel {
    private String nome;
    private String humor;
    private String objetivo;

    public Pessoa(String nome, String humor, String objetivo) {
        this.nome = nome;
        this.humor = humor;
        this.objetivo = objetivo;
    }

    public String getNome() {
        return nome;
    }

    public String getHumor() {
        return humor;
    }

    public String getObjetivo() {
        return objetivo;
    }

    @Override
    public String toCsvRow() {
        return nome + "," + humor + "," + objetivo;
    }

    @Override
    public String getCsvHeader() {
        return "nome,humor,objetivo";
    }

    public void cantar() {
        System.out.println("A pessoa está cantando.");
    }

    public void dancar() {
        System.out.println("A pessoa está dançando.");
    }

    public void sorrir() {
        System.out.println("A pessoa está sorrindo.");
    }
}
