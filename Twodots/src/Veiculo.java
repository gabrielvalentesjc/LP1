public class Veiculo {
    private String nome;
    private String categoria;
    private String marca;

    public Veiculo(String nome, String categoria, String marca) {
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
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