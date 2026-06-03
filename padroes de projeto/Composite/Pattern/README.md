# Composite Pattern

## Estrutura

## Diagrama UML (Mermaid)

```mermaid
classDiagram
    class ConteudoCurso {
        <<interface>>
        +exibir(String indentacao) void
        +getDuracaoMinutos() int
    }

    class Aula {
        -String titulo
        -int duracaoMinutos
        +Aula(String titulo, int duracaoMinutos)
        +exibir(String indentacao) void
        +getDuracaoMinutos() int
    }

    class Modulo {
        -String titulo
        -List~ConteudoCurso~ conteudos
        +Modulo(String titulo)
        +adicionar(ConteudoCurso conteudo) void
        +remover(ConteudoCurso conteudo) void
        +exibir(String indentacao) void
        +getDuracaoMinutos() int
    }

    ConteudoCurso <|.. Aula
    ConteudoCurso <|.. Modulo
    Modulo o-- ConteudoCurso : conteudos
```

## Diagrama UML (ASCII)

```
+------------------------------+
|        <<interface>>         |
|       ConteudoCurso          |
|------------------------------|
| + exibir(indentacao): void   |
| + getDuracaoMinutos(): int   |
+------------------------------+
              ^
              | implements
       _______|________
       |              |
       v              v
+-------------+  +------------------------+
|    Aula     |  |        Modulo          |
| (Leaf)      |  |      (Composite)       |
|-------------|  |------------------------|
| - titulo    |  | - titulo               |
| - duracao   |  | - conteudos: List      |
|-------------|  |------------------------|
| + exibir()  |  | + adicionar(Conteudo)  |
| + getDur... |  | + remover(Conteudo)    |
+-------------+  | + exibir()             |
                 | + getDuracaoMinutos()  |
                 +------------------------+
```

## Hierarquia de exemplo

```
[Curso Java]
  [Fundamentos]
    - Variaveis: 20 min
    - Condicionais: 30 min
  [Orientacao a Objetos]
    [Classes e Objetos]
      - Classes: 35 min
      - Objetos: 25 min
```

## Por que e um PATTERN?

- Cliente usa a mesma interface para aulas e modulos.
- Permite hierarquias arbitrarias sem if/else no cliente.
- A duracao total e calculada recursivamente.
