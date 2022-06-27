/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ControleCompras;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Compra;

/**
 *
 * @author gabri
 */
public class ViewCompra {

    private Scanner scan = new Scanner(System.in);
    private ControleCompras controler = new ControleCompras();

    // Função para cadastrar uma Compra
    public void cadastrarCompra() {
        Compra c = new Compra();

        System.out.print(" \nInforme o número da compra: ");
        c.setNrCompra(scan.nextInt());

        System.out.print(" \nInforme o nome do fornecedor: ");
        c.setFornecedor(scan.next());

        System.out.print(" \nInforme a quantidade comprada: ");
        c.setQuantComprada(scan.nextInt());
        
        System.out.print(" \nInforme o valor da compra: ");
        c.setValorCompra(scan.nextDouble());
        try {
            controler.inserirCompra(c);
            System.out.print(" \nCompra cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.print(" \nNão foi possível cadastrar a compra");
            System.out.println(e.getMessage());
        }

    }

    // Função para apresentar uma Compra
    public void apresentarDadosCompra(Compra c) {
        System.out.print(" \nNúmero da compra: " + c.getNrCompra());
        System.out.print(" \nFornecedor: " + c.getFornecedor());
        System.out.print(" \nQuantidade comprada: " + c.getQuantComprada());
        System.out.print(" \nValor da compra: " + c.getValorCompra());

    }

    // Função para excluir uma Compra
    public void excluirCompra() {
        int codigo;
        String confirmar;
        Compra c;
        System.out.print(" \nDigite o número da compra que deseja excluir: ");
        codigo = scan.nextInt();
        try {
            c = controler.pesquisarCompra(codigo);
            apresentarDadosCompra(c);
            System.out.print(" \nConfirmar a exclusão ? S/N: ");
            confirmar = scan.next();
            if (confirmar.equals("S") || confirmar.equals("s")) {
                controler.excluirCompra(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na exclusão : " + e.getMessage());
        }
    }

    // Função para Listar as Compras
    public void listarCompras() {
        List<Compra> listaCompras;
        try {
            listaCompras = controler.retornarTodasCompras();
            for (Compra c : listaCompras) {
                System.out.println(c.getNrCompra()+ "\n" + c.getFornecedor()+ "\n" + c.getQuantComprada()+ "\n" + c.getValorCompra());
            }
        } catch (SQLException ex) {
            System.out.print(" \nErro ao listar as Compras");
        }
    }

}
