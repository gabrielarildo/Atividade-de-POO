/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import connection.ConnectionDataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

/**
 *
 * @author gabri
 */
public class ControleVendas {

     // Faz a inserção da Venda no Banco de Dados
     public void inserirVenda(Venda v) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Criar a String contendo o SQL
        String comandoSQL = "INSERT INTO venda (nrNF, dataVenda, formaPagto) VALUES(?, ?, ?)";

        // Preparar a String para a execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQL
        execSQL.setInt(1, v.getNrNF());
        execSQL.setDate(2, (Date) v.getData());
        execSQL.setString(3, v.getFormaPagto());

        // Executar o comando SQL montado
        execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

    }

    // Faz a exclusão da Venda no Banco de Dados
    public void excluirVenda(int nrNF) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Criar a String contendo o SQL
        String comandoSQL = "DELETE FROM venda WHERE nrNF = ?";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar o parâmetro para o SQL
        execSQL.setInt(1, nrNF);

        // Executar o comando SQL montado
        int linhas = execSQL.executeUpdate();

        // Fazer o commit na connection
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        if (linhas == 0) {
            System.out.print(" /nVenda com o número físcal " + nrNF + " não existe");
        }

    }

    // Faz a alteração da Venda no Banco de Dados
    public void alterarVenda(Venda v) throws SQLException {

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uma String contendo o SQL
        String comandoSQL = "UPDATE venda set nrNF = ?, dataVenda = ?, formaPagto = ?";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Passar os parâmetros para o SQl
        execSQL.setInt(1, v.getNrNF());
        execSQL.setDate(2, (Date) v.getData());
        execSQL.setString(3, v.getFormaPagto());

        // Executar o comando do SQl montado retornando o número de linhas afetadas
        int quantidadeDeLinhasAlteradas = execSQL.executeUpdate();

        // Fazer o commit na connetion
        connection.commit();

        // Finaliza a execução do SQL
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        if (quantidadeDeLinhasAlteradas == 0) {
            System.out.print(" \nNota Fiscal da venda não foi encontrado");
        }

    }

    // Faz a pesquisa da Venda no Banco de Dados
    public Venda pesquisarVenda(int nrNF) throws SQLException {

        // Venda a ser Retornada
        Venda v = null;

        Connection connection = ConnectionDataBase.getConexao();

        // Criar uma String contendo o SQL
        String comandoSQL = "SELECT * FROM venda WHERE nrNF = ?";

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
            v = new Venda();
            v.setNrNF(nrNF);
            v.setNrNF(resultadoPesquisa.getInt("nrNF"));
            v.setData(resultadoPesquisa.getDate("data"));
            v.setFormaPagto(resultadoPesquisa.getString("formaPagto"));
        } else {
            System.out.print(" \nVenda não foi encontrada");
        }

        // Finaliza a execução do SQl
        execSQL.close();

        // Finaliza a connection com o Banco de Dados
        connection.close();

        return v;
    }

    // Retorna todas Vendas
    public List<Venda> retornarTodasVendas() throws SQLException {

        // Lista contendo as Vendas
        List<Venda> listaVendas = new ArrayList<>();

        Connection connection = ConnectionDataBase.getConexao();

        // Cria uam String contendo o SQL
        String comandoSQL = "SELECT * FROM venda";

        // Preparar a String para execução do SQL
        PreparedStatement execSQL;

        // Preparar a String para execução do SQL
        execSQL = connection.prepareStatement(comandoSQL);

        // Objeto criado para armazenar o resultado de uma consulta do SQL
        ResultSet resultadoListaVendas;

        // Executa a consulta
        resultadoListaVendas = execSQL.executeQuery();

        Venda v;

        // Verifica se tem mais registros no resultadoListaVendas
        while (resultadoListaVendas.next()) {
            // Preencher o objeto Venda com dados do banco
            v = new Venda();
            v.setNrNF(resultadoListaVendas.getInt("nrNF"));
            v.setData(resultadoListaVendas.getDate("data"));
            v.setFormaPagto(resultadoListaVendas.getString("formaPagto"));

            // Adiciona lista de VEndas
            listaVendas.add(v);
        }
        return listaVendas;
    }
    
}
