package pattern;

public class EmailAluno implements CursoObserver {
    private final String email;

    public EmailAluno(String email) {
        this.email = email;
    }

    @Override
    public void atualizar(String nomeCurso, String status) {
        System.out.printf("[EMAIL -> %s] Curso %s: %s%n", email, nomeCurso, status);
    }
}

