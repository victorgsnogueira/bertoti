# Observer Pattern

## Estrutura

## Diagrama UML (Mermaid)

```mermaid
classDiagram
    class CursoObserver {
        <<interface>>
        +atualizar(String nomeCurso, String status) void
    }

    class EmailAluno {
        -String email
        +EmailAluno(String email)
        +atualizar(String nomeCurso, String status) void
    }

    class PainelProfessor {
        -String professor
        +PainelProfessor(String professor)
        +atualizar(String nomeCurso, String status) void
    }

    class AppMentoria {
        -String mentor
        +AppMentoria(String mentor)
        +atualizar(String nomeCurso, String status) void
    }

    class GerenciadorCurso {
        -String nomeCurso
        -List~CursoObserver~ observers
        -String status
        +adicionarObserver(CursoObserver observer) void
        +removerObserver(CursoObserver observer) void
        +atualizarStatus(String novoStatus) void
        -notificarTodos() void
    }

    CursoObserver <|.. EmailAluno
    CursoObserver <|.. PainelProfessor
    CursoObserver <|.. AppMentoria
    GerenciadorCurso o-- CursoObserver : observers
```

## Diagrama UML (ASCII)

```
+-------------------------------+
|        <<interface>>          |
|       CursoObserver           |
|-------------------------------|
| + atualizar(curso, status)    |
+-------------------------------+
              ^
              | implements
    __________|_____________
    |          |            |
    v          v            v
+----------+ +----------+ +-------------+
|EmailAluno| |Painel    | |AppMentoria  |
|          | |Professor | |             |
+----------+ +----------+ +-------------+

+--------------------------------+
|        GerenciadorCurso        | <Subject>
|--------------------------------|
| - nomeCurso: String            |
| - status: String               |
| - observers: List<Observer>    |
|--------------------------------|
| + adicionarObserver(Observer)  |
| + removerObserver(Observer)    |
| + atualizarStatus(String)      |
| - notificarTodos()             |
+--------------------------------+
```

## Relacoes

| Elemento         | Papel                |
|------------------|----------------------|
| CursoObserver    | Observer interface   |
| EmailAluno       | ConcreteObserver A   |
| PainelProfessor  | ConcreteObserver B   |
| AppMentoria      | ConcreteObserver C   |
| GerenciadorCurso | Subject / Publisher  |

## Por que e um PATTERN?

- O subject nao conhece os tipos concretos de notificacao.
- Novos canais podem se registrar sem alterar `GerenciadorCurso`.
- Observers podem ser adicionados e removidos em runtime.
- Reduz acoplamento entre evento e reacao.
