import java.util.Scanner;

public class CalculoMedia {

    // Atributos da classe para armazenar as notas
    private double p1;  // Prova 1
    private double e1;  // Entrega E1
    private double e2;  // Entrega E2
    private double x;   // Atividades extras
    private double sub; // Prova substitutiva
    private double api; // Aprendizagem por Projeto Integrado

    public CalculoMedia() {
    }

    // Método para ler as notas do teclado com validação
    public void lerNotas() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Entrada de Notas ---");

        // Validação da Prova 1 (P1)
        do {
            System.out.print("Digite a nota da Prova 1 (P1) [0-10]: ");
            this.p1 = scanner.nextDouble();
            if (p1 < 0 || p1 > 10) {
                System.out.println("Valor inválido. A nota da P1 deve ser entre 0 e 10.");
            }
        } while (p1 < 0 || p1 > 10);

        // Validação da Entrega E1
        do {
            System.out.print("Digite a nota da Entrega E1 [0-10]: ");
            this.e1 = scanner.nextDouble();
            if (e1 < 0 || e1 > 10) {
                System.out.println("Valor inválido. A nota da E1 deve ser entre 0 e 10.");
            }
        } while (e1 < 0 || e1 > 10);

        // Validação da Entrega E2
        do {
            System.out.print("Digite a nota da Entrega E2 [0-10]: ");
            this.e2 = scanner.nextDouble();
            if (e2 < 0 || e2 > 10) {
                System.out.println("Valor inválido. A nota da E2 deve ser entre 0 e 10.");
            }
        } while (e2 < 0 || e2 > 10);

        // Validação das Atividades extras (X)
        do {
            System.out.print("Digite a nota das Atividades extras (X) [0-2]: ");
            this.x = scanner.nextDouble();
            if (x < 0 || x > 2) {
                System.out.println("Valor inválido. A nota de X deve ser entre 0 e 2.");
            }
        } while (x < 0 || x > 2);

        // Validação da Prova substitutiva (SUB)
        do {
            System.out.print("Digite a nota da Prova substitutiva (SUB) [0-10]: ");
            this.sub = scanner.nextDouble();
            if (sub < 0 || sub > 10) {
                System.out.println("Valor inválido. A nota da SUB deve ser entre 0 e 10.");
            }
        } while (sub < 0 || sub > 10);

        // Validação da Aprendizagem por Projeto Integrado (API)
        do {
            System.out.print("Digite a nota da Aprendizagem por Projeto Integrado (API) [0-10]: ");
            this.api = scanner.nextDouble();
            if (api < 0 || api > 10) {
                System.out.println("Valor inválido. A nota da API deve ser entre 0 e 10.");
            }
        } while (api < 0 || api > 10);

        scanner.close();
    }

    // Método para calcular a média com a nova lógica
    public double calcularMedia() {
        // Passo 1: Considera a maior nota entre P1 e SUB para a prova
        double notaProva = Math.max(p1, sub);

        // Passo 2: Calcula a média "normal" da disciplina (incluindo X)
        double mediaNormal = (notaProva * 0.5) + (e1 * 0.2) + (e2 * 0.3) + x;

        // Passo 3: Aplica a lógica condicional da API
        if (mediaNormal > 5.9) {
            // Se a média normal for maior que 5.9, a API entra com 50%
            return Math.min((mediaNormal * 0.5) + (api * 0.5), 10.0);
        } else {
            // Caso contrário, a média final é apenas a média normal
            return Math.min(mediaNormal, 10.0);
        }
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        CalculoMedia calculador = new CalculoMedia();
        calculador.lerNotas();

        double media = calculador.calcularMedia();

        System.out.println("\n--- Resultado ---");
        System.out.printf("A Média Final é: %.2f%n", media);
    }
}