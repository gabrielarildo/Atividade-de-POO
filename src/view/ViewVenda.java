/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ControleVendas;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Venda;

/**
 *
 * @author gabri
 */
public class ViewVenda {

    private Scanner scan = new Scanner(System.in);
    private ControleVendas controler = new ControleVendas();

    // Função para cadastrar uma Venda
    public void cadastrarVenda() {
        Venda v = new Venda();

        System.out.print(" \nInforme o número da venda: ");
        v.setNrNF(scan.nextInt());

        //System.out.print(" \nInforme a data da venda: ");
        //v.setData(scan.nextDate());
        System.out.print(" \nInforme a forma de pagamento: ");
        v.setFormaPagto(scan.next());
        try {
            controler.inserirVenda(v);
            System.out.print(" \nVenda cadastrada com sucesso");
        } catch (SQLException e) {
            System.out.print(" \nNão foi possível cadastrar a venda");
            System.out.println(e.getMessage());
        }

    }

    // Função para apresentar uma Venda
    public void apresentarDadosVenda(Venda v) {
        System.out.print(" \nNúmero da venda: " + v.getNrNF());
        System.out.print(" \nData: " + v.getData());
        System.out.print(" \nForma de pagamento: " + v.getFormaPagto());

    }

    // Função para excluir uma Venda
    public void excluirVenda() {
        int codigo;
        String confirmar;
        Venda v;
        System.out.print(" \nDigite o número da venda que deseja excluir: ");
        codigo = scan.nextInt();
        try {
            v = controler.pesquisarVenda(codigo);
            apresentarDadosVenda(v);
            System.out.print(" \nConfirmar a exclusão ? S/N: ");
            confirmar = scan.next();
            if (confirmar.equals("S") || confirmar.equals("s")) {
                controler.excluirVenda(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na exclusão : " + e.getMessage());
        }
    }

    // Função para Listar as Vendas
    public void listarCompras() {
        List<Venda> listaVendas;
        try {
            listaVendas = controler.retornarTodasVendas();
            for (Venda v : listaVendas) {
                System.out.println(v.getNrNF()+ "\n" + v.getData()+ "\n" + v.getFormaPagto()+ "\n");
            }
        } catch (SQLException ex) {
            System.out.print(" \nErro ao listar as Vendas");
        }
    }
}
