package pattern;

public class AvaliacaoPorPresenca implements AvaliacaoStrategy {
    private final double presencaMinima;

    public AvaliacaoPorPresenca(double presencaMinima) {
        this.presencaMinima = presencaMinima;
    }

    @Override
    public boolean aprovado(double nota, double presenca) {
        return presenca >= presencaMinima;
    }
}

