package com.example.lp1_e1.Model.Video;

import com.example.lp1_e1.Model.Registravel;

public class TutorialVideo implements Registravel {
    private String titulo;
    private int duracao;
    private String autor;

    public TutorialVideo(String titulo, int duracao, String autor) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.autor = autor;
    }

    @Override
    public String toCsvRow() {
        return titulo + "," + duracao + "," + autor;
    }

    @Override
    public String getCsvHeader() {
        return "titulo,duracao,autor";
    }

    public void executar() {
        System.out.println("O vídeo \'" + titulo + "\' está sendo executado.");
    }

    public void pausar() {
        System.out.println("O vídeo \'" + titulo + "\' foi pausado.");
    }

    public void darDica() {
        System.out.println("O vídeo \'" + titulo + "\' dá uma dica.");
    }
}
