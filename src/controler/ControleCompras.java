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
import model.Compra;

/**
 *
 * @author gabri
 */
public class ControleCompras {
     // Faz a inserção da Compra no Banco de Dados
     public void inserirCompra(Compra c) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Criar a String contendo o SQL
        String comandoSQL = "INSERT INTO compra (nrCompra, fornecedor, quantComprada, valorCompra) VALUES(?, ?, ?, ?)";

        // Preparar a String para a execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQL
        execSQL.setInt(1, c.getNrCompra());
        execSQL.setString(2, c.getFornecedor());
        execSQL.setInt(3, c.getQuantComprada());
        execSQL.setDouble(4, c.getValorCompra());

        // Executar o comando SQL montado
        execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

    }

    // Faz a exclusão da Compra no Banco de Dados
    public void excluirCompra(int nrCompra) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Criar a String contendo o SQL
        String comandoSQL = "DELETE FROM compra WHERE nrCompra = ?";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar o parâmetro para o SQL
        execSQL.setInt(1, nrCompra);

        // Executar o comando SQL montado
        int linhas = execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        if (linhas == 0) {
            System.out.print(" /nCompra com o número " + nrCompra + " não existe");
        }

    }

    // Faz a alteração da Compra no Banco de Dados
    public void alterarCompra(Compra c) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uma String contendo o SQL
        String comandoSQL = "UPDATE compra set nrCompra = ?, fornecedor = ?, quantComprada = ?, valorCompra = ?";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQl
        execSQL.setInt(1, c.getNrCompra());
        execSQL.setString(2, c.getFornecedor());
        execSQL.setInt(3, c.getQuantComprada());
        execSQL.setDouble(4, c.getValorCompra());

        // Executar o comando do SQl montado retornando o número de linhas afetadas
        int quantidadeDeLinhasAlteradas = execSQL.executeUpdate();

        // Fazer o commit na connetion
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        if (quantidadeDeLinhasAlteradas == 0) {
            System.out.print(" \nNúmero da compra não foi encontrado");
        }

    }
    
    // Faz a pesquisa da Compra no Banco de Dados
    public Compra pesquisarCompra(int nrCompra) throws SQLException {

        // Compra a ser Retornada
        Compra c = null;

        Connection connection = ConnectionDataBase.getConexao();

        // Criar uma String contendo o SQL
        String comandoSQL = "SELECT * FROM compra WHERE nrCompra = ?";

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
            c = new Compra();
            c.setNrCompra(nrCompra);
            c.setNrCompra(resultadoPesquisa.getInt("nrCompra"));
            c.setFornecedor(resultadoPesquisa.getString("fornecedor"));
            c.setQuantComprada(resultadoPesquisa.getInt("quantComprada"));
            c.setValorCompra(resultadoPesquisa.getDouble("valorCompra"));
        } else {
            System.out.print(" \nCompra não foi encontrada");
        }

        // Finaliza a execução do SQl
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        return c;
    }

    // Retorna todas Compras
    public List<Compra> retornarTodasCompras() throws SQLException {

        // Lista contendo as Compras
        List<Compra> listaCompras = new ArrayList<>();

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uam String contendo o SQL
        String comandoSQL = "SELECT * FROM compra";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Objeto criado para armazenar o resultado de uma consulta do SQL
        ResultSet resultadoListaCompras;

        // Executa a consulta
        resultadoListaCompras = execSQL.executeQuery();

        Compra c;

        // Verifica se tem mais registros no resultadoListaCompras
        while (resultadoListaCompras.next()) {
            // Preencher o objeto Venda com dados do banco
            c = new Compra();
            c.setNrCompra(resultadoListaCompras.getInt("nrCompra"));
            c.setFornecedor(resultadoListaCompras.getString("fornecedor"));
            c.setQuantComprada(resultadoListaCompras.getInt("quantCompra"));
            c.setValorCompra(resultadoListaCompras.getDouble("valorCompra"));

            // Adiciona lista de VEndas
            listaCompras.add(c);
        }
        return listaCompras;
    }
}
