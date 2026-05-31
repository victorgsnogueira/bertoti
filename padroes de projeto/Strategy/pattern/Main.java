package pattern;

public class Main {
    public static void main(String[] args) {
        Matricula matricula = new Matricula("Lia", 8.5, 72);

        matricula.setAvaliacaoStrategy(new AvaliacaoPorNota(7.0));
        matricula.emitirResultado();

        matricula.setAvaliacaoStrategy(new AvaliacaoPorPresenca(75));
        matricula.emitirResultado();

        matricula.setAvaliacaoStrategy(new AvaliacaoPorProjeto(8.0, 70));
        matricula.emitirResultado();
    }
}

