package mvp;

public class AppMentoria implements MatriculaObserver {
    private final String mentor;

    public AppMentoria(String mentor) {
        this.mentor = mentor;
    }

    @Override
    public void atualizar(String aluno, String curso, String status) {
        System.out.printf("Mentoria de %s recebeu alerta sobre %s: %s%n", mentor, aluno, status);
    }
}

