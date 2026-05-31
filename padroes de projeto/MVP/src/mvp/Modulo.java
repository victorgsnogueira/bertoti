package mvp;

import java.util.ArrayList;
import java.util.List;

public class Modulo implements ConteudoCurso {
    private final String titulo;
    private final List<ConteudoCurso> conteudos = new ArrayList<>();

    public Modulo(String titulo) {
        this.titulo = titulo;
    }

    public void adicionar(ConteudoCurso conteudo) {
        conteudos.add(conteudo);
    }

    @Override
    public void exibir(String indentacao) {
        System.out.printf("%s[%s] subtotal: %d min%n", indentacao, titulo, getDuracaoMinutos());
        for (ConteudoCurso conteudo : conteudos) {
            conteudo.exibir(indentacao + "  ");
        }
    }

    @Override
    public int getDuracaoMinutos() {
        return conteudos.stream().mapToInt(ConteudoCurso::getDuracaoMinutos).sum();
    }
}

