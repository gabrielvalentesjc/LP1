public class Pai {
    private String nome;
    private int nivelHabilidadePentear;
    private String emocao;

    public Pai(String nome, int nivelHabilidadePentear, String emocao) {
        this.nome = nome;
        this.nivelHabilidadePentear = nivelHabilidadePentear;
        this.emocao = emocao;
    }

    public void tentarPentear() {
        System.out.println(nome + " tenta pentear.");
    }

    public void assistirVideoTutorial() {
        System.out.println(nome + " assiste a um tutorial.");
    }

    public void abracar() {
        System.out.println(nome + " abraça alguém.");
    }
}