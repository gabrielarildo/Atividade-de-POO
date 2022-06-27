/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import connection.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author gabri
 */
public class ControleClientes {

    // Faz a inserção do Cliente no Banco de Dados
    public void inserirCliente(Cliente c) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Criar a String contendo o SQL
        String comandoSQL = "INSERT INTO cliente (codigo, nome, contato) VALUES(?, ?, ?)";

        // Preparar a String para a execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQL
        execSQL.setInt(1, c.getCodigo());
        execSQL.setString(2, c.getNome());
        execSQL.setString(3, c.getContato());

        // Executar o comando SQL montado
        execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

    }

    // Faz a exclusão do Cliente no Banco de Dados
    public void excluirCliente(int codigo) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Criar a String contendo o SQL
        String comandoSQL = "DELETE FROM cliente WHERE codigo = ?";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar o parâmetro para o SQL
        execSQL.setInt(1, codigo);

        // Executar o comando SQL montado
        int linhas = execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        if (linhas == 0) {
            System.out.print(" /nClinte com o código " + codigo + " não existe");
        }

    }

    // Faz a alteração do Cliente no Banco de Dados
    public void alterarCliente(Cliente c) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uma String contendo o SQL
        String comandoSQL = "UPDATE cliente set codigo = ?, nome = ?, contato = ?";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQl
        execSQL.setInt(1, c.getCodigo());
        execSQL.setString(2, c.getNome());
        execSQL.setString(3, c.getContato());

        // Executar o comando do SQl montado retornando o número de linhas afetadas
        int quantidadeDeLinhasAlteradas = execSQL.executeUpdate();

        // Fazer o commit na connetion
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        if (quantidadeDeLinhasAlteradas == 0) {
            System.out.print(" \nCódigo do cliente não foi encontrado");
        }

    }

    // Faz a pesquisa do Produto no Banco de Dados
    public Cliente pesquisarCliente(int codigo) throws SQLException {

        // Cliente a ser Retornado
        Cliente c = null;

        Connection connection = ConnectionDataBase.getConexao();

        // Criar uma String contendo o SQL
        String comandoSQL = "SELECT * FROM cliente WHERE codigo = ?";

        // Preparar a String para a execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para a execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Objeto criado para armazenar o resultado do SQL
        ResultSet resultadoPesquisa;

        // Executa a pesquisa
        resultadoPesquisa = execSQL.executeQuery();

        // Avança para a última linha
        resultadoPesquisa.last();

        // Pega o número da última linha
        if (resultadoPesquisa.getRow() > 0) {
            c = new Cliente();
            c.setCodigo(codigo);
            c.setCodigo(resultadoPesquisa.getInt("codigo"));
            c.setNome(resultadoPesquisa.getString("nome"));
            c.setContato(resultadoPesquisa.getString("contato"));
        } else {
            System.out.print(" \nCliente não foi encontrado");
        }

        // Finaliza a execução do SQl
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        return c;
    }

    // Retorna todos os CLientes
    public List<Cliente> retornarTodosClientes() throws SQLException {

        // Lista contendo os Clientes
        List<Cliente> listaClientes = new ArrayList<>();

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uam String contendo o SQL
        String comandoSQL = "SELECT * FROM clinte";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Objeto criado para armazenar o resultado de uma consulta do SQL
        ResultSet resultadoListaClientes;

        // Executa a consulta
        resultadoListaClientes = execSQL.executeQuery();

        Cliente c;

        // Verifica se tem mais registros no resultadoListaClientes
        while (resultadoListaClientes.next()) {
            // Preencher o objeto Cliente com dados do banco
            c = new Cliente();
            c.setCodigo(resultadoListaClientes.getInt("codigo"));
            c.setNome(resultadoListaClientes.getString("nome"));
            c.setContato(resultadoListaClientes.getString("contato"));

            // Adiciona lista de Clientes
            listaClientes.add(c);
        }
        return listaClientes;
    }

    public void alterarCliente(int codigo) {

    }
}
