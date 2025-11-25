package org.example.lp1_e2.Model;

public class Pessoa {
    private int id; // Novo atributo para o Banco de Dados
    private String nome;
    private String humor;
    private String objetivo;

    // Construtor vazio (Obrigatório para o DAO)
    public Pessoa() {
    }

    // Construtor cheio (Usado pela interface gráfica para criar novos)
    public Pessoa(String nome, String humor, String objetivo) {
        this.nome = nome;
        this.humor = humor;
        this.objetivo = objetivo;
    }

    // Getters e Setters (Necessários para o DAO ler e escrever)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHumor() {
        return humor;
    }

    public void setHumor(String humor) {
        this.humor = humor;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    // Métodos da lógica original
    public void cantar() {
        System.out.println("A pessoa está cantando.");
    }

    public void dancar() {
        System.out.println("A pessoa está dançando.");
    }

    public void sorrir() {
        System.out.println("A pessoa está sorrindo.");
    }

    // Métodos antigos (CSV) - Podem ser mantidos ou removidos se não usar mais CSV
    public String toCsvRow() {
        return nome + "," + humor + "," + objetivo;
    }

    public String getCsvHeader() {
        return "nome,humor,objetivo";
    }
}