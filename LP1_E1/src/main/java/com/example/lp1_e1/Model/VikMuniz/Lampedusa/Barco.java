package com.example.lp1_e1.Model.VikMuniz.Lampedusa;

import com.example.lp1_e1.Model.Registravel;

public class Barco implements Registravel {
    private String modelo;
    private String material;
    private String tamanho;

    public Barco(String modelo, String material, String tamanho) {
        this.modelo = modelo;
        this.material = material;
        this.tamanho = tamanho;
    }

    @Override
    public String toCsvRow() {
        return modelo + "," + material + "," + tamanho;
    }

    @Override
    public String getCsvHeader() {
        return "modelo,material,tamanho";
    }

    public void navegar() {
        System.out.println("O barco está navegando.");
    }

    public void ancorar() {
        System.out.println("O barco está ancorando.");
    }

    public void flutuar() {
        System.out.println("O barco está flutuando.");
    }
}
