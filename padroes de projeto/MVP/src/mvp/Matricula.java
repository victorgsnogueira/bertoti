package mvp;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private final String aluno;
    private final String curso;
    private final ConteudoCurso trilha;
    private final List<MatriculaObserver> observers = new ArrayList<>();
    private AvaliacaoStrategy avaliacaoStrategy;
    private String status = "Criada";

    public Matricula(String aluno, String curso, ConteudoCurso trilha) {
        this.aluno = aluno;
        this.curso = curso;
        this.trilha = trilha;
    }

    public void setAvaliacaoStrategy(AvaliacaoStrategy avaliacaoStrategy) {
        this.avaliacaoStrategy = avaliacaoStrategy;
    }

    public void adicionarObserver(MatriculaObserver observer) {
        observers.add(observer);
    }

    public void exibirTrilha() {
        System.out.println("Trilha da matricula de " + aluno + " em " + curso);
        trilha.exibir("  ");
        System.out.printf("Carga horaria total: %d min%n", trilha.getDuracaoMinutos());
    }

    public void avaliar(double nota, double presenca) {
        if (avaliacaoStrategy == null) {
            throw new IllegalStateException("Escolha um criterio de avaliacao antes de avaliar.");
        }

        boolean aprovado = avaliacaoStrategy.aprovado(nota, presenca);
        String resultado = aprovado ? "Aprovado" : "Reprovado";
        System.out.printf("%nCriterio: %s%n", avaliacaoStrategy.getDescricao());
        atualizarStatus(resultado + " com nota " + nota + " e presenca " + presenca + "%");
    }

    public void atualizarStatus(String novoStatus) {
        status = novoStatus;
        System.out.printf("%nStatus da matricula de %s: %s%n", aluno, status);
        notificarTodos();
    }

    private void notificarTodos() {
        for (MatriculaObserver observer : observers) {
            observer.atualizar(aluno, curso, status);
        }
    }
}

