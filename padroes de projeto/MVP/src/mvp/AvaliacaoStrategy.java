package mvp;

public interface AvaliacaoStrategy {
    boolean aprovado(double nota, double presenca);

    String getDescricao();
}

