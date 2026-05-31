package pattern;

public class PainelProfessor implements CursoObserver {
    private final String professor;

    public PainelProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public void atualizar(String nomeCurso, String status) {
        System.out.printf("[PAINEL PROFESSOR -> %s] Curso %s: %s%n", professor, nomeCurso, status);
    }
}

