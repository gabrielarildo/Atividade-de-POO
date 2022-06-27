/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ControleClientes;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Cliente;

/**
 *
 * @author gabri
 */
public class ViewCliente {

    private Scanner scan = new Scanner(System.in);
    private ControleClientes controler = new ControleClientes();

    // Função para cadastrar um Cliente
    public void cadastrarCliente() {
        Cliente c = new Cliente();

        System.out.print(" \nInforme o código do cliente: ");
        c.setCodigo(scan.nextInt());

        System.out.print(" \nInforme o nome do cliente: ");
        c.setNome(scan.next());

        System.out.print(" \nInforme o contato do cliente: ");
        c.setContato(scan.next());
        try {
            controler.inserirCliente(c);
            System.out.print(" \nCliente cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.print(" \nNão foi possível cadastrar em cliente");
            System.out.println(e.getMessage());
        }

    }

    // Função para apresentar um Cliente
    public void apresentarDadosCliente(Cliente c) {
        System.out.print(" \nCodigo: " + c.getCodigo());
        System.out.print(" \nNome: " + c.getNome());
        System.out.print(" \nContato: " + c.getContato());

    }

    // Função para excluir um Cliente
    public void excluirCliente() {
        int codigo;
        String confirmar;
        Cliente c;
        System.out.print(" \nDigite o código do cliente que deseja excluir: ");
        codigo = scan.nextInt();
        try {
            c = controler.pesquisarCliente(codigo);
            apresentarDadosCliente(c);
            System.out.print(" \nConfirmar a exclusão ? S/N: ");
            confirmar = scan.next();
            if (confirmar.equals("S") || confirmar.equals("s")) {
                controler.excluirCliente(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na exclusão : " + e.getMessage());
        }
    }

    // Funçaõ para alterar um Cliente
    public void alterarCliente() {
        int codigo;
        String confirmar;
        Cliente c;
        System.out.print(" \nDigite o código do cliente que deseja fazer a alteração: ");
        codigo = scan.nextInt();
        try {
            c = controler.pesquisarCliente(codigo);
            apresentarDadosCliente(c);
            System.out.print(" \nConfirmar a alteração ? S/N: ");
            confirmar = scan.next();
            if (confirmar.equals("S") || confirmar.equals("s")) {
                controler.alterarCliente(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na exclusão : " + e.getMessage());
        }
    }

    // Função para pesquisar um Cliente
    public void pesquisarCliente() {
        int codigo;
        String pesquisar;
        Cliente c;
        System.out.print(" \nDigite o código do cliente que deseja pesquisar: ");
        codigo = scan.nextInt();
        try {
            c = controler.pesquisarCliente(codigo);
            apresentarDadosCliente(c);
            System.out.print(" \nConfirmar a pesquisa ? S/N: ");
            pesquisar = scan.next();
            if (pesquisar.equals("S") || pesquisar.equals("s")) {
                controler.pesquisarCliente(codigo);
            }
        } catch (SQLException e) {
            System.out.print(" \nErro na pesquisa : " + e.getMessage());
        }
    }

    // Função para Listar os Clientes
    public void listarClientes() {
        List<Cliente> listaClientes;
        try {
            listaClientes = controler.retornarTodosClientes();
            for (Cliente c : listaClientes) {
                System.out.println(c.getCodigo() + "\n" + c.getNome() + "\n" + c.getContato()+ "\n");
            }
        } catch (SQLException ex) {
            System.out.print(" \nErro ao listar os Clientes");
        }
    }
}
