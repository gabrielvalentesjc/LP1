package org.example.lp1_e2.Model;


public class Pessoa  {
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

    public String toCsvRow() {
        return nome + "," + humor + "," + objetivo;
    }

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
