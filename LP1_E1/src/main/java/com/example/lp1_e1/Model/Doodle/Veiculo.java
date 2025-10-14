package com.example.lp1_e1.Model.Doodle;

import com.example.lp1_e1.Model.Registravel;

public class Veiculo implements Registravel {
    private String nome;
    private String categoria;
    private String marca;

    public Veiculo(String nome, String categoria, String marca) {
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
    }

    @Override
    public String toCsvRow() {
        return nome + "," + categoria + "," + marca;
    }

    @Override
    public String getCsvHeader() {
        return "nome,categoria,marca";
    }

    public void andar() {
        System.out.println("O " + nome + " está andando.");
    }

    public void buzinar() {
        System.out.println("O " + nome + " está buzinando.");
    }

    public void freiar() {
        System.out.println("O " + nome + " está freiando.");
    }
}
