package com.example.lp1_e1.Model.VikMuniz.Lampedusa;

import com.example.lp1_e1.Model.Registravel;

public class Rio implements Registravel {
    private String nome;
    private Double extensao;
    private Double temperatura;

    public Rio(String nome, Double extensao, Double temperatura) {
        this.nome = nome;
        this.extensao = extensao;
        this.temperatura = temperatura;
    }

    public String getNome() {
        return nome;
    }

    public Double getExtensao() {
        return extensao;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toCsvRow() {
        return nome + "," + extensao + "," + temperatura;
    }

    @Override
    public String getCsvHeader() {
        return "nome,extensao,temperatura";
    }

    public void abastecerCidade() {
        System.out.println("O rio esta abastecendo a cidade");
    }
}
