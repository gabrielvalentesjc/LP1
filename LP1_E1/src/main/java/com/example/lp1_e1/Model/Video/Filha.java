package com.example.lp1_e1.Model.Video;

import com.example.lp1_e1.Model.Registravel;

public class Filha implements Registravel {
    private String nome;
    private int nivelSatisfacao;
    private String humor;

    public Filha(String nome, int nivelSatisfacao, String humor) {
        this.nome = nome;
        this.nivelSatisfacao = nivelSatisfacao;
        this.humor = humor;
    }

    @Override
    public String toCsvRow() {
        return nome + "," + nivelSatisfacao + "," + humor;
    }

    @Override
    public String getCsvHeader() {
        return "nome,nivelSatisfacao,humor";
    }

    public void mostrarTutorialAoPai() {
        System.out.println(nome + " mostra um tutorial ao pai.");
    }

    public void reagirPentear() {
        System.out.println(nome + " reage ao penteado.");
    }

    public void sorrir() {
        System.out.println(nome + " sorri.");
    }
}
