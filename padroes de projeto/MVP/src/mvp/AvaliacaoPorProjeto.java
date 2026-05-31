package mvp;

public class AvaliacaoPorProjeto implements AvaliacaoStrategy {
    private final double notaMinima;
    private final double presencaMinima;

    public AvaliacaoPorProjeto(double notaMinima, double presencaMinima) {
        this.notaMinima = notaMinima;
        this.presencaMinima = presencaMinima;
    }

    @Override
    public boolean aprovado(double nota, double presenca) {
        return nota >= notaMinima && presenca >= presencaMinima;
    }

    @Override
    public String getDescricao() {
        return "projeto com nota " + notaMinima + " e presenca " + presencaMinima + "%";
    }
}

