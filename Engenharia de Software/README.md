Atividade 1 - Analise e Comentario sobre o trecho do livro "Software Engineering at Google"

Com base nos trechos lidos, entendo que engenharia de software vai muito além do que somente codar, ela envolve pensamentos que vão além, como longevidade do código, escalabilidade e custos referente ao software, seja ele tempo ou dinheiro com ferramentas para auxiliar, acredito que a engenharia de software existe para mudar a forma como enxergamos o ato de programar em si, não levando em conta somente performance e experiencia de usuário.


Atividade 2: Citar 3 trade-offs

1- Desempenho vs. Facilidade de Manutenção
Escolha 1: Escrever um código altamente otimizado, mas complexo, difícil de entender e manter.

Escolha 2: Escrever um código mais claro e modular, mas com um desempenho um pouco inferior.

Trade-off: Código otimizado pode ser mais rápido, mas difícil de modificar no futuro. Código legível é mais fácil de manter, mas pode não ser tão eficiente.

2- Velocidade de Desenvolvimento vs. Qualidade do Código
Escolha 1: Lançar o produto rapidamente, mesmo que o código tenha alguns bugs e débitos técnicos.

Escolha 2: Garantir um código bem testado e estruturado, mesmo que isso atrase o lançamento.

Trade-off: Se lançar rápido, pode ter mais problemas no futuro. Se priorizar qualidade, pode perder oportunidades de mercado.

3- Funcionalidade vs. Experiência do Usuário (UX)
Escolha 1: Adicionar muitas funcionalidades avançadas, tornando o produto poderoso, mas complexo.

Escolha 2: Manter a interface simples e intuitiva, mesmo que com menos funcionalidades.

Trade-off: Mais funcionalidades podem atrair usuários avançados, mas afastar os iniciantes. Um design mais simples pode ser mais acessível, mas pode faltar recursos importantes.


Atividade 3: Java
```java
package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class LojaJogos {

    String url = "jdbc:sqlite:lojagames.db";

    public void Conectar() {

        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void criarTabela() {


        // SQL statement for creating a new table
        var sql = "CREATE TABLE IF NOT EXISTS jogos ("
                + "	id int PRIMARY KEY,"
                + "	jogo text NOT NULL"
                + ");";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addJogo(String jogo) {
        String sql = "INSERT INTO jogos(jogo) VALUES(?)";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, jogo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void buscarTodos() {
        var sql = "SELECT * FROM jogos";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {


            System.out.println(rs);
            while (rs.next()) {
                System.out.println(rs.getString("jogo"));

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

package org.example;

public class Main {

    private static final LojaJogos jogos = new LojaJogos();

    public static void main(String[] args) {
        jogos.Conectar();
        jogos.criarTabela();
        jogos.addJogo("Bully");
        jogos.buscarTodos();
    }
}
```
