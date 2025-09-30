package com.example.lp1_e1;

public class CalculoMedia {

    private double p1;
    private double e1;
    private double e2;
    private double x;
    private double sub;
    private double api;

    public void setNotas(double p1, double e1, double e2, double x, double sub, double api) {
        this.p1 = p1;
        this.e1 = e1;
        this.e2 = e2;
        this.x = x;
        this.sub = sub;
        this.api = api;
    }

    // Método para calcular a média
    public double calcularMedia() {
        double notaProva = Math.max(p1, sub); // pega a maior entre P1 e SUB
        double mediaNormal = (notaProva * 0.5) + (e1 * 0.2) + (e2 * 0.3) + x;

        if (mediaNormal > 5.9) {
            return Math.min((mediaNormal * 0.5) + (api * 0.5), 10.0);
        } else {
            return Math.min(mediaNormal, 10.0);
        }
    }
}