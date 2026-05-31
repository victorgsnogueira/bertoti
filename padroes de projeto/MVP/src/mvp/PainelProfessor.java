package mvp;

public class PainelProfessor implements MatriculaObserver {
    private final String professor;

    public PainelProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public void atualizar(String aluno, String curso, String status) {
        System.out.printf("Painel de %s atualizou %s em %s: %s%n", professor, aluno, curso, status);
    }
}

