package anti_pattern;

public class Main {
    public static void main(String[] args) {
        ModuloAntiPattern curso = new ModuloAntiPattern("Curso Java");
        curso.adicionarAula(new AulaAntiPattern("Variaveis", 20));

        ModuloAntiPattern oo = new ModuloAntiPattern("Orientacao a Objetos");
        oo.adicionarAula(new AulaAntiPattern("Classes", 35));
        oo.adicionarAula(new AulaAntiPattern("Objetos", 25));

        curso.adicionarSubmodulo(oo);

        exibirModulo(curso, "");
        System.out.printf("%nDuracao total: %d min%n", calcularDuracao(curso));
    }

    private static void exibirModulo(ModuloAntiPattern modulo, String indentacao) {
        System.out.println(indentacao + "[" + modulo.getTitulo() + "]");

        for (AulaAntiPattern aula : modulo.getAulas()) {
            System.out.printf("%s  - %s: %d min%n", indentacao, aula.getTitulo(), aula.getDuracaoMinutos());
        }

        for (ModuloAntiPattern submodulo : modulo.getSubmodulos()) {
            exibirModulo(submodulo, indentacao + "  ");
        }
    }

    private static int calcularDuracao(ModuloAntiPattern modulo) {
        int total = 0;

        for (AulaAntiPattern aula : modulo.getAulas()) {
            total += aula.getDuracaoMinutos();
        }

        for (ModuloAntiPattern submodulo : modulo.getSubmodulos()) {
            total += calcularDuracao(submodulo);
        }

        return total;
    }
}

