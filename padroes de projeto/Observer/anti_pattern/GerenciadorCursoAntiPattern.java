package anti_pattern;

public class GerenciadorCursoAntiPattern {
    private final String nomeCurso;
    private String status;
    private String emailAluno;
    private String professor;
    private String mentor;

    public GerenciadorCursoAntiPattern(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void configurarEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public void configurarPainelProfessor(String professor) {
        this.professor = professor;
    }

    public void configurarAppMentoria(String mentor) {
        this.mentor = mentor;
    }

    public void atualizarStatus(String novoStatus) {
        status = novoStatus;
        System.out.println("\n[" + nomeCurso + "] Status: " + status);

        if (emailAluno != null) {
            System.out.printf("[EMAIL -> %s] Curso %s: %s%n", emailAluno, nomeCurso, status);
        }

        if (professor != null) {
            System.out.printf("[PAINEL PROFESSOR -> %s] Curso %s: %s%n", professor, nomeCurso, status);
        }

        if (mentor != null) {
            System.out.printf("[APP MENTORIA -> %s] Curso %s: %s%n", mentor, nomeCurso, status);
        }
    }
}

