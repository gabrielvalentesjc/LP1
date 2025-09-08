package john;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Cria um objeto das classes
        Cantor cantor = new Cantor();
        Caneca caneca 	  = new Caneca();
        Cafe cafe 	  = new Cafe();

        // Chama os métodos
        cantor.cantar();
        caneca.armazenarBebida();
        cafe.darEnergia();
    }
}