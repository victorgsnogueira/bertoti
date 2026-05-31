package mvp;

public class NotificacaoAluno implements MatriculaObserver {
    private final String email;

    public NotificacaoAluno(String email) {
        this.email = email;
    }

    @Override
    public void atualizar(String aluno, String curso, String status) {
        System.out.printf("Email enviado para %s: %s no curso %s - %s%n", email, aluno, curso, status);
    }
}

