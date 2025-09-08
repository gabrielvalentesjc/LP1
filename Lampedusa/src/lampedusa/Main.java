package lampedusa;

public class Main {
    public static void main(String[] args) {
        // Cria um objeto das classes
        Barco barco = new Barco();
        Cidade cidade 	  = new Cidade();
        Rio rio 	  = new Rio();

        // Chama os métodos
        barco.navegar();
        cidade.abrigarPessoas();
        rio.abastecerCidade();
    }
}