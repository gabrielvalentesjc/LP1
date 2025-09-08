public class TutorialVideo {
    private String titulo;
    private int duracao;
    private String autor;

    public TutorialVideo(String titulo, int duracao, String autor) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.autor = autor;
    }

    public void executar() {
        System.out.println("O vídeo '" + titulo + "' está sendo executado.");
    }

    public void pausar() {
        System.out.println("O vídeo '" + titulo + "' foi pausado.");
    }

    public void darDica() {
        System.out.println("O vídeo '" + titulo + "' dá uma dica.");
    }
}