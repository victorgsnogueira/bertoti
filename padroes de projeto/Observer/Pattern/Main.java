package pattern;

public class Main {
    public static void main(String[] args) {
        GerenciadorCurso curso = new GerenciadorCurso("Java para Iniciantes");

        curso.adicionarObserver(new EmailAluno("lia@email.com"));
        curso.adicionarObserver(new PainelProfessor("Prof. Bruno"));
        curso.adicionarObserver(new AppMentoria("Mentora Carla"));

        curso.atualizarStatus("Matricula confirmada");
        curso.atualizarStatus("Modulo 1 liberado");
        curso.atualizarStatus("Certificado disponivel");
    }
}

