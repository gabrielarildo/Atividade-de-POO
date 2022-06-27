/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ControleProdutos;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Produto;

/**
 *
 * @author gabri
 */
public class ViewProduto {

    private Scanner scan = new Scanner(System.in);
    private ControleProdutos controler = new ControleProdutos();

    // Função para cadastrar um Produto
    public void cadastrarProduto() {
        Produto p = new Produto();

        System.out.print(" \nInforme o código do produto: ");
        p.setCodigo(scan.nextInt());

        System.out.print(" \nInforme a descrição do produto ? : ");
        p.setDescricao(scan.next());

        System.out.print(" \nInforme a quantidade de produtos: ");
        p.setQuant(scan.nextInt());

        System.out.print(" \nInforme o valor da venda: ");
        p.setValorVenda(scan.nextDouble());

        System.out.print(" \nInforme o valor do curso: ");
        p.setValorCusto(scan.nextDouble());

        try {
            controler.inserirProduto(p);
            System.out.print(" \nProduto cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.print(" \nNão foi possível cadastrar o Produto");
            System.out.println(e.getMessage());
        }

    }

    // Função para apresentar um Produto
    public void apresentarDadosProduto(Produto p) {
        System.out.print(" \nCodigo: " + p.getCodigo());
        System.out.print(" \nDescrição: " + p.getDescricao());
        System.out.print(" \nQuantidade: " + p.getQuant());
        System.out.print(" \nValor da Venda: " + p.getValorVenda());
        System.out.print(" \nValor do Custo: " + p.getValorCusto());

    }

    // Função para excluir um Produto
    public void excluirProduto() {
        int codigo;
        String confirmar;
        Produto p;
        System.out.print(" \nDigite o código do produto que deseja excluir: ");
        codigo = scan.nextInt();
        try {
            p = controler.pesquisarProduto(codigo);
            apresentarDadosProduto(p);
            System.out.print(" \nConfirmar a exclusão ? S/N: ");
            confirmar = scan.next();
            if (confirmar.equals("S") || confirmar.equals("s")) {
                controler.excluirProduto(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na exclusão : " + e.getMessage());
        }
    }

    // Funçaõ para alterar um produto
    public void alterarProduto() {
        int codigo;
        String confirmar;
        Produto p;
        System.out.print(" \nDigite o código do produto que deseja fazer a alteração: ");
        codigo = scan.nextInt();
        try {
            p = controler.pesquisarProduto(codigo);
            apresentarDadosProduto(p);
            System.out.print(" \nConfirmar a alteração ? S/N: ");
            confirmar = scan.next();
            if (confirmar.equals("S") || confirmar.equals("s")) {
                controler.alterarProduto(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na exclusão : " + e.getMessage());
        }
    }

    // Função para pesquisar um produto
    public void pesquisarProduto() {
        int codigo;
        String pesquisar;
        Produto p;
        System.out.print(" \nDigite o código do produto que deseja pesquisar: ");
        codigo = scan.nextInt();
        try {
            p = controler.pesquisarProduto(codigo);
            apresentarDadosProduto(p);
            System.out.print(" \nConfirmar a pesquisa ? S/N: ");
            pesquisar = scan.next();
            if (pesquisar.equals("S") || pesquisar.equals("s")) {
                controler.pesquisarProduto(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na pesquisa : " + e.getMessage());
        }
    }

    // Função para Listar os produtos
    public void listarProdutos() {
        List<Produto> listaProdutos;
        try {
            listaProdutos = controler.retornarTodosProdutos();
            for (Produto p : listaProdutos) {
                System.out.println(p.getCodigo() + "\n" + p.getDescricao() + "\n" + p.getQuant() + "\n" + p.getValorCusto() + "\n" + p.getValorVenda());
            }
        } catch (SQLException ex) {
            System.out.print(" \nErro ao listar os Produtos");
        }
    }

}
