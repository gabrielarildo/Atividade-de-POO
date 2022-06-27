/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class ConnectionDataBase {

    //   jdbc: protocolo
    //   mysql: sgbd
    //   localhost - endereço da máquina onde está o banco
    //   3306 - porta onde o servidor está ouvindo
    //   academico -  nome do banco de dados
    private static String urlBanco = "jdbc:mysql://localhost:3306/gerenciamento_de_estoque?useSSL=false";

    public static Connection getConexao() {
        // estabelecer conexão com o banco de dados
        // declara um objeto de conexão
        Connection conexao = null;
        try {
            // estabelece cponexão com o banco de dados
            conexao = DriverManager.getConnection(urlBanco, "*****", "**********");
            // retira o autcommit da conexão
            conexao.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Não foi possível fazer conexão com o banco");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return conexao;
    }
}
