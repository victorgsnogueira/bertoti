package mvp;

public class Main {
    public static void main(String[] args) {
        Modulo fundamentos = new Modulo("Fundamentos de Java");
        fundamentos.adicionar(new Aula("Tipos e variaveis", 25));
        fundamentos.adicionar(new Aula("Condicionais e loops", 35));

        Modulo orientacaoObjetos = new Modulo("Orientacao a Objetos");
        orientacaoObjetos.adicionar(new Aula("Classes e objetos", 40));
        orientacaoObjetos.adicionar(new Aula("Encapsulamento", 30));

        Modulo projetoFinal = new Modulo("Projeto Final");
        projetoFinal.adicionar(new Aula("Desafio pratico", 50));
        projetoFinal.adicionar(new Aula("Apresentacao do projeto", 20));

        Modulo trilha = new Modulo("Trilha Java Developer");
        trilha.adicionar(fundamentos);
        trilha.adicionar(orientacaoObjetos);
        trilha.adicionar(projetoFinal);

        Matricula matricula = new Matricula("Lia", "Java Developer", trilha);
        matricula.adicionarObserver(new NotificacaoAluno("lia@email.com"));
        matricula.adicionarObserver(new PainelProfessor("Prof. Bruno"));
        matricula.adicionarObserver(new AppMentoria("Carla"));

        matricula.exibirTrilha();

        matricula.atualizarStatus("Matricula confirmada");
        matricula.atualizarStatus("Modulo de fundamentos concluido");

        matricula.setAvaliacaoStrategy(new AvaliacaoPorProjeto(8.0, 70));
        matricula.avaliar(8.7, 82);

        System.out.println("\nReavaliando com outro criterio:");
        matricula.setAvaliacaoStrategy(new AvaliacaoPorNota(9.0));
        matricula.avaliar(8.7, 82);
    }
}

