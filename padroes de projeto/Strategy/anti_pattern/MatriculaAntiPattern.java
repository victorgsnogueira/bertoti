package anti_pattern;

public class MatriculaAntiPattern {
    private final String aluno;
    private final double nota;
    private final double presenca;
    private final String tipoAvaliacao;

    public MatriculaAntiPattern(String aluno, double nota, double presenca, String tipoAvaliacao) {
        this.aluno = aluno;
        this.nota = nota;
        this.presenca = presenca;
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public void emitirResultado() {
        boolean aprovado = false;

        if (tipoAvaliacao.equals("nota")) {
            aprovado = nota >= 7.0;
        } else if (tipoAvaliacao.equals("presenca")) {
            aprovado = presenca >= 75;
        } else if (tipoAvaliacao.equals("projeto")) {
            aprovado = nota >= 8.0 && presenca >= 70;
        }

        String resultado = aprovado ? "aprovado" : "reprovado";
        System.out.printf("%s foi %s usando criterio '%s'.%n", aluno, resultado, tipoAvaliacao);
    }
}

