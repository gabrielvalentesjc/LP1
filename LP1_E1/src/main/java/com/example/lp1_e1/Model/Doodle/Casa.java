package com.example.lp1_e1.Model.Doodle;

import com.example.lp1_e1.Model.Registravel;

public class Casa implements Registravel {
    private String endereco;
    private String cor;
    private double tamanho;

    public Casa(String endereco, String cor, double tamanho) {
        this.endereco = endereco;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    @Override
    public String toCsvRow() {
        return endereco + "," + cor + "," + tamanho;
    }

    @Override
    public String getCsvHeader() {
        return "endereco,cor,tamanho";
    }

    public void abrirPorta() {
        System.out.println("A porta da casa em " + endereco + " está sendo aberta.");
    }

    public void fecharPorta() {
        System.out.println("A porta da casa em " + endereco + " está sendo fechada.");
    }

    public void entrarPessoa() {
        System.out.println("Uma pessoa está entrando na casa em " + endereco + ".");
    }
}
