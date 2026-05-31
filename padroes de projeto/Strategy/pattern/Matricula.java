package pattern;

public class Matricula {
    private final String aluno;
    private final double nota;
    private final double presenca;
    private AvaliacaoStrategy avaliacaoStrategy;

    public Matricula(String aluno, double nota, double presenca) {
        this.aluno = aluno;
        this.nota = nota;
        this.presenca = presenca;
    }

    public void setAvaliacaoStrategy(AvaliacaoStrategy avaliacaoStrategy) {
        this.avaliacaoStrategy = avaliacaoStrategy;
    }

    public void emitirResultado() {
        if (avaliacaoStrategy == null) {
            throw new IllegalStateException("Defina um criterio de avaliacao antes de emitir o resultado.");
        }

        boolean aprovado = avaliacaoStrategy.aprovado(nota, presenca);
        String resultado = aprovado ? "aprovado" : "reprovado";
        System.out.printf("%s foi %s. Nota: %.1f | Presenca: %.0f%%%n", aluno, resultado, nota, presenca);
    }
}

