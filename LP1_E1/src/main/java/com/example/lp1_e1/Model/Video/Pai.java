package com.example.lp1_e1.Model.Video;

import com.example.lp1_e1.Model.Registravel;

public class Pai implements Registravel {
    private String nome;
    private int nivelHabilidadePentear;
    private String emocao;

    public Pai(String nome, int nivelHabilidadePentear, String emocao) {
        this.nome = nome;
        this.nivelHabilidadePentear = nivelHabilidadePentear;
        this.emocao = emocao;
    }

    @Override
    public String toCsvRow() {
        return nome + "," + nivelHabilidadePentear + "," + emocao;
    }

    @Override
    public String getCsvHeader() {
        return "nome,nivelHabilidadePentear,emocao";
    }

    public void tentarPentear() {
        System.out.println(nome + " tenta pentear.");
    }

    public void assistirVideoTutorial() {
        System.out.println(nome + " assiste a um tutorial.");
    }

    public void abracar() {
        System.out.println(nome + " abraça alguém.");
    }
}
