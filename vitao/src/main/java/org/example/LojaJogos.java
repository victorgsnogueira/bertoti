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

    public void addJogos(String nome, String ra) {
        String sql = "INSERT INTO sala(ra,name) VALUES('" + ra + "','" + nome + "')";
        System.out.println(sql);
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void buscarTodos() {
        var sql = "SELECT * FROM sala";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {


            System.out.println(rs);
            while (rs.next()) {
                System.out.println(rs.getString("ra"));
                System.out.println(rs.getString("name"));

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
