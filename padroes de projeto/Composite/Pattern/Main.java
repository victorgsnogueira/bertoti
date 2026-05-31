package pattern;

public class Main {
    public static void main(String[] args) {
        Modulo fundamentos = new Modulo("Fundamentos");
        fundamentos.adicionar(new Aula("Variaveis", 20));
        fundamentos.adicionar(new Aula("Condicionais", 30));

        Modulo classesObjetos = new Modulo("Classes e Objetos");
        classesObjetos.adicionar(new Aula("Criando classes", 35));
        classesObjetos.adicionar(new Aula("Instanciando objetos", 25));

        Modulo orientacaoObjetos = new Modulo("Orientacao a Objetos");
        orientacaoObjetos.adicionar(classesObjetos);
        orientacaoObjetos.adicionar(new Aula("Encapsulamento", 40));

        Modulo curso = new Modulo("Curso Java");
        curso.adicionar(fundamentos);
        curso.adicionar(orientacaoObjetos);

        curso.exibir("");
        System.out.printf("%nDuracao total: %d min%n", curso.getDuracaoMinutos());
    }
}

