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
import model.Produto;

/**
 *
 * @author gabri
 */
public class ControleProdutos {

    // Faz a inserção do Produto no Banco de Dados
    public void inserirProduto(Produto p) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Criar a string contendo o SQL
        String comandoSQL = "INSERT INTO produto (codigo, descricao, quant, valorVenda, valorCusto) VALUES(?, ?, ?, ?, ?)";

        // Preparar a string para execução do SQL
        PreparedStatement execSQL;

        // Preparar a string para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQL
        execSQL.setInt(1, p.getCodigo());
        execSQL.setString(2, p.getDescricao());
        execSQL.setInt(3, p.getQuant());
        execSQL.setDouble(4, p.getValorVenda());
        execSQL.setDouble(5, p.getValorCusto());

        // Executar o comando SQL montado
        execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o banco de dados
        connection.close();

    }

    // Faz a exclusão do Produto no Banco de Dados
    public void excluirProduto(int codigo) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Cria a String contendo o SQL
        String comandoSQL = "DELETE FROM produto WHERE codigo = ?";

        // Preparar a String para a execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para a execução do SQL
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
            System.out.print(" \nProduto com o código " + codigo + " não existe");
        }

    }

    // Faz a alteração do Produto no Banco de Dados
    public void alterarProduto(Produto p) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uma String contendo o SQL
        String comandoSQL = "UPDATE produto set codigo = ?, descricao = ?, quant = ?,"
                + "valorVenda = ?, vlaorCusto = ?";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para a execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQL
        execSQL.setInt(1, p.getCodigo());
        execSQL.setString(2, p.getDescricao());
        execSQL.setInt(3, p.getQuant());
        execSQL.setDouble(4, p.getValorVenda());
        execSQL.setDouble(5, p.getValorCusto());

        // Executar o comando SQL montando retornando o número de linhas afetadas
        int quantidadeDeLinhasAlteradas = execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza e execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        if (quantidadeDeLinhasAlteradas == 0) {
            System.out.print(" \nCódigo do produto não foi encontrado");
        }

    }

    // Faz a pesquisa do Produto no Banco de Dados
    public Produto pesquisarProduto(int codigo) throws SQLException {

        // Produto a ser retornado
        Produto p = null;

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uma String contendo o SQL
        String comandoSQL = "SELECT * FROM produto WHERE codigo = ?";

        // Preparar a String para a execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para a execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar o parâmetro para o SQl
        execSQL.setInt(1, codigo);

        // Objeto criado para armazenar o resultado do SQL
        ResultSet resultadoPesquisa;

        // Executa a pesquisa
        resultadoPesquisa = execSQL.executeQuery();

        // Avança para a última liha
        resultadoPesquisa.last();

        // Pega o número da última linha
        if (resultadoPesquisa.getRow() > 0) {
            p = new Produto();
            p.setCodigo(codigo);
            p.setCodigo(resultadoPesquisa.getInt("codigo"));
            p.setDescricao(resultadoPesquisa.getString("descricao"));
            p.setQuant(resultadoPesquisa.getInt("quant"));
            p.setValorVenda(resultadoPesquisa.getDouble("valorVenda"));
            p.setValorCusto(resultadoPesquisa.getDouble("valorCusto"));
        } else {
           System.out.print(" \nProduto não foi encontrado");
        }

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connetion com o Banco de Dados
        connection.close();

        return p;
    }

    // Retorna todos os Produtos
    public List<Produto> retornarTodosProdutos() throws SQLException {

        // Lista contendo os Produtos
        List<Produto> listaProdutos = new ArrayList<>();

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uma String contendo o SQL
        String comandoSQL = "SELECT * FROM produto";

        // Preparar a String para a execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para a execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Objeto criado para armazenar o resultado de uma consulta SQL
        ResultSet resultadoListaProdutos;

        // Executa a consuta
        resultadoListaProdutos = execSQL.executeQuery();

        Produto p;

        // Verifica se tem mais registros no resultadoListaProdutos
        while (resultadoListaProdutos.next()) {
            // Preencher o objeto Produto com dados do banco
            p = new Produto();
            p.setCodigo(resultadoListaProdutos.getInt("codigo"));
            p.setDescricao(resultadoListaProdutos.getString("descricao"));
            p.setQuant(resultadoListaProdutos.getInt("quant"));
            p.setValorVenda(resultadoListaProdutos.getDouble("valorVenda"));
            p.setValorCusto(resultadoListaProdutos.getDouble("valorCusto"));

            // Adiciona lista de Produtos
            listaProdutos.add(p);
        }
        return listaProdutos;
    }

    public Produto alterarProduto(int codigo) {
        return null;
    }

}
