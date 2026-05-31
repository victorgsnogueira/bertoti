package anti_pattern;

public class AulaAntiPattern {
    private final String titulo;
    private final int duracaoMinutos;

    public AulaAntiPattern(String titulo, int duracaoMinutos) {
        this.titulo = titulo;
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
}

