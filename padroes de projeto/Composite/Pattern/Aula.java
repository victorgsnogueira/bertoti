package pattern;

public class Aula implements ConteudoCurso {
    private final String titulo;
    private final int duracaoMinutos;

    public Aula(String titulo, int duracaoMinutos) {
        this.titulo = titulo;
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.printf("%s- %s: %d min%n", indentacao, titulo, duracaoMinutos);
    }

    @Override
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
}

