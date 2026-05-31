# MVP - Plataforma de Cursos com 3 Padroes de Projeto

Este MVP simula uma plataforma de cursos online usando os tres padroes do
repositorio:

- **Composite**: `Aula` e `Modulo` implementam `ConteudoCurso`, permitindo
  montar trilhas com aulas simples e modulos aninhados.
- **Strategy**: `Matricula` usa `AvaliacaoStrategy` para alternar o criterio de
  aprovacao entre nota, presenca e projeto.
- **Observer**: `Matricula` notifica `NotificacaoAluno`, `PainelProfessor` e
  `AppMentoria` sempre que o status muda.

## Como executar

Na pasta `MVP`:

```bash
javac -d out src/mvp/*.java
java -cp out mvp.Main
```

## Fluxo demonstrado

1. A trilha do curso e montada com aulas e modulos.
2. A matricula calcula a carga horaria usando a arvore do Composite.
3. O criterio de aprovacao e escolhido via Strategy.
4. Cada mudanca de status dispara notificacoes via Observer.

