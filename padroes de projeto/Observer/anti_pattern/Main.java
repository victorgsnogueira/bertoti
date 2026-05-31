package anti_pattern;

public class Main {
    public static void main(String[] args) {
        GerenciadorCursoAntiPattern curso = new GerenciadorCursoAntiPattern("Java para Iniciantes");

        curso.configurarEmailAluno("lia@email.com");
        curso.configurarPainelProfessor("Prof. Bruno");
        curso.configurarAppMentoria("Mentora Carla");

        curso.atualizarStatus("Matricula confirmada");
        curso.atualizarStatus("Modulo 1 liberado");
    }
}

