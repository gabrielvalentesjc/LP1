public class Casa {
    private String endereco;
    private String cor;
    private double tamanho;

    public Casa(String endereco, String cor, double tamanho) {
        this.endereco = endereco;
        this.cor = cor;
        this.tamanho = tamanho;
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
