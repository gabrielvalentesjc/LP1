package musica; 

public class Main {
    public static void main(String[] args) {
        // Cria um objeto da classe Pessoa
        Pessoa pessoa = new Pessoa();
        Dia dia 	  = new Dia();
        Sol sol 	  = new Sol();
        
        // Chama o método procurarLuz() da classe Pessoa
        pessoa.procurarLuz();
        dia.transcorrer();
        sol.brilhar();
    }
}
