package org.example.lp1_e2.Model;

public class Dia {
    private int id; // Novo atributo
    private String periodo;
    private String clima;
    private String evento;

    // Construtor vazio
    public Dia() {
    }

    public Dia(String periodo, String clima, String evento) {
        this.periodo = periodo;
        this.clima = clima;
        this.evento = evento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    // Métodos da lógica original
    public void amanhecer() {
        System.out.println("O dia está amanhecendo.");
    }

    public void entardecer() {
        System.out.println("O dia está entardecendo.");
    }

    public void anoitecer() {
        System.out.println("O dia está anoitecendo.");
    }

    public String toCsvRow() {
        return periodo + "," + clima + "," + evento;
    }

    public String getCsvHeader() {
        return "periodo,clima,evento";
    }
}