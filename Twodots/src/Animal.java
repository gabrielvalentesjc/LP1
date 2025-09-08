public class Animal {
    private String especie;
    private int idade;
    private double peso;

    public Animal(String especie, int idade, double peso) {
        this.especie = especie;
        this.idade = idade;
        this.peso = peso;
    }

    public void comer() {
        System.out.println("O animal da espécie " + especie + " está comendo.");
    }

    public void fazerBarulho() {
        System.out.println("O animal da espécie " + especie + " faz um barulho.");
    }

    public void dormir() {
        System.out.println("O animal da espécie " + especie + " está dormindo.");
    }
}
