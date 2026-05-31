package pattern;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorCurso {
    private final String nomeCurso;
    private final List<CursoObserver> observers = new ArrayList<>();
    private String status;

    public GerenciadorCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void adicionarObserver(CursoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(CursoObserver observer) {
        observers.remove(observer);
    }

    public void atualizarStatus(String novoStatus) {
        status = novoStatus;
        System.out.println("\n[" + nomeCurso + "] Status atualizado para: " + status);
        notificarTodos();
    }

    private void notificarTodos() {
        for (CursoObserver observer : observers) {
            observer.atualizar(nomeCurso, status);
        }
    }
}

