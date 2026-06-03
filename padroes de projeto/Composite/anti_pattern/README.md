# Composite AntiPattern

## Estrutura

## Diagrama UML (Mermaid)

```mermaid
classDiagram
    class AulaAntiPattern {
        -String titulo
        -int duracaoMinutos
        +AulaAntiPattern(String titulo, int duracaoMinutos)
        +getTitulo() String
        +getDuracaoMinutos() int
    }

    class ModuloAntiPattern {
        -String titulo
        -List~AulaAntiPattern~ aulas
        -List~ModuloAntiPattern~ submodulos
        +ModuloAntiPattern(String titulo)
        +adicionarAula(AulaAntiPattern aula) void
        +adicionarSubmodulo(ModuloAntiPattern submodulo) void
        +getTitulo() String
        +getAulas() List~AulaAntiPattern~
        +getSubmodulos() List~ModuloAntiPattern~
    }

    class Main {
        +main(String[] args) void
        -exibirModulo(ModuloAntiPattern modulo, String indentacao) void
        -calcularDuracao(ModuloAntiPattern modulo) int
    }

    ModuloAntiPattern o-- AulaAntiPattern : aulas
    ModuloAntiPattern o-- ModuloAntiPattern : submodulos
    Main ..> ModuloAntiPattern : trata manualmente
    Main ..> AulaAntiPattern : trata manualmente
```

## Diagrama UML (ASCII)

```
+------------------------------+    +------------------------------+
|       ModuloAntiPattern      |    |        AulaAntiPattern       |
|------------------------------|    |------------------------------|
| - titulo: String             |    | - titulo: String             |
| - aulas: List<Aula>          |    | - duracaoMinutos: int        |
| - submodulos: List<Modulo>   |    |------------------------------|
|------------------------------|    | + getTitulo(): String        |
| + adicionarAula(Aula)        |    | + getDuracaoMinutos(): int   |
| + adicionarSubmodulo(Modulo) |    +------------------------------+
| + getAulas(): List<Aula>     |
| + getSubmodulos(): List      |
+------------------------------+
```

## Problema

Nao existe uma interface comum entre `ModuloAntiPattern` e `AulaAntiPattern`.
O cliente precisa tratar aulas e submodulos manualmente.

## Como corrigir?

Criar a interface `ConteudoCurso` com `exibir()` e `getDuracaoMinutos()`.
Aulas e modulos passam a ser usados de forma uniforme.
