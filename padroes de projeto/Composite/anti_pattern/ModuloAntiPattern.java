package anti_pattern;

import java.util.ArrayList;
import java.util.List;

public class ModuloAntiPattern {
    private final String titulo;
    private final List<AulaAntiPattern> aulas = new ArrayList<>();
    private final List<ModuloAntiPattern> submodulos = new ArrayList<>();

    public ModuloAntiPattern(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarAula(AulaAntiPattern aula) {
        aulas.add(aula);
    }

    public void adicionarSubmodulo(ModuloAntiPattern submodulo) {
        submodulos.add(submodulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public List<AulaAntiPattern> getAulas() {
        return aulas;
    }

    public List<ModuloAntiPattern> getSubmodulos() {
        return submodulos;
    }
}

