package pattern;

public class AppMentoria implements CursoObserver {
    private final String mentor;

    public AppMentoria(String mentor) {
        this.mentor = mentor;
    }

    @Override
    public void atualizar(String nomeCurso, String status) {
        System.out.printf("[APP MENTORIA -> %s] Curso %s: %s%n", mentor, nomeCurso, status);
    }
}

