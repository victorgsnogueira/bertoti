package mvp;

public class AvaliacaoPorNota implements AvaliacaoStrategy {
    private final double notaMinima;

    public AvaliacaoPorNota(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    @Override
    public boolean aprovado(double nota, double presenca) {
        return nota >= notaMinima;
    }

    @Override
    public String getDescricao() {
        return "nota minima " + notaMinima;
    }
}

