/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import view.ViewCliente;
import view.ViewCompra;
import view.ViewProduto;
import view.ViewVenda;

/**
 *
 * @author gabri
 */
public class ViewAll {

    public static int menu() {
        int op;

        Scanner teclado = new Scanner(System.in);

        System.out.print("\n\t\t!!!GERENCIAMENTO DE ESTOQUE!!!\n");
        System.out.print("  \n  Sair..............................[0]       \n");
        System.out.print("  PRODUTO....................[1]         \n");
        System.out.print("  CLIENTE....................[2]         \n");
        System.out.print("  COMPRA.....................[3]         \n");
        System.out.print("  VENDA......................[4]         \n");

        do {
            System.out.print(" \nQual opção deseja entrar.: ");
            op = teclado.nextInt();
        } while (op < 0 || op > 4);

        return op;
    }

    public static int menu2() {
        int op2;

        Scanner teclado = new Scanner(System.in);

        System.out.print(" \n\t\t!!!PRODUTO!!!\n");
        System.out.print("  \n  Sair........................................[0]       \n");
        System.out.print("  Inserir Produto...........................[1]         \n");
        System.out.print("  Alterar Produto...........................[2]         \n");
        System.out.print("  Excluir Produto...........................[3]         \n");
        System.out.print("  Listar Produtos...........................[4]         \n");

        do {
            System.out.print("   \nQual opcao deseja executar.: ");
            op2 = teclado.nextInt();
        } while (op2 < 0 || op2 > 4);

        return op2;
    }

    public static int menu3() {
        int op3;

        Scanner teclado = new Scanner(System.in);

        System.out.print(" \n\t\t!!!CLIENTE!!!\n");
        System.out.print("  \n  Sair........................................[0]       \n");
        System.out.print("  Inserir cliente...........................[1]         \n");
        System.out.print("  Alterar cliente...........................[2]         \n");
        System.out.print("  Excluir cliente...........................[3]         \n");
        System.out.print("  Listar cliente............................[4]         \n");

        do {
            System.out.print("   \nQual opcao deseja executar.: ");
            op3 = teclado.nextInt();
        } while (op3 < 0 || op3 > 4);

        return op3;
    }

    public static int menu4() {
        int op4;

        Scanner teclado = new Scanner(System.in);

        System.out.print(" \n\t\t!!!COMPRA!!!\n");
        System.out.print("  \n  Sair........................................[0]       \n");
        System.out.print("  Inserir Compra...........................[1]         \n");
        System.out.print("  Excluir Compra...........................[2]         \n");

        do {
            System.out.print("   \nQual opcao deseja executar.: ");
            op4 = teclado.nextInt();
        } while (op4 < 0 || op4 > 2);

        return op4;
    }

    public static int menu5() {
        int op5;

        Scanner teclado = new Scanner(System.in);

        System.out.print(" \n\t\t!!!VENDA!!!\n");
        System.out.print("  \n  Sair........................................[0]       \n");
        System.out.print("  Inserir Venda...........................[1]         \n");
        System.out.print("  Excluir Venda...........................[2]         \n");

        do {
            System.out.print("   \nQual opcao deseja executar.: ");
            op5 = teclado.nextInt();
        } while (op5 < 0 || op5 > 2);

        return op5;
    }

    public static void main(String[] args) {
        int op, op2, op3, op4, op5;

        ViewProduto produto = new ViewProduto();
        ViewCliente cliente = new ViewCliente();
        ViewCompra compra = new ViewCompra();
        ViewVenda venda = new ViewVenda();

        try {
            // Carregar o driver para acesso ao bando de dados MySql
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {

            // o driver não foi encontrado
            System.out.println("Driver não encontrado: com.mysql.jdbc.Driver");
            System.exit(0);
        }

        do {
            op = menu();

            switch (op) {
                case 1: {
                    do {
                        op2 = menu2();

                        switch (op2) {
                            case 1: {
                                System.out.print(" \nINSERINDO PRODUTOS\n");
                                produto.cadastrarProduto();
                            }
                                break;
                            case 2: {
                                System.out.print(" \nALTERANDO PRODUTO\n");
                                produto.alterarProduto();
                            }
                                break;
                            case 3: {
                                System.out.print(" \nEXCLUINDO PRODUTO\n");
                                produto.excluirProduto();
                            }
                                break;
                            case 4: {
                                System.out.print(" \nALTERANDO PRODUTO\n");
                                produto.alterarProduto();
                            }
                                break;
                        }
                    } while (op2 != 0);
                    break;
                }
                case 2: {
                    do {
                        op3 = menu3();

                        switch (op3) {
                            case 1: {
                                System.out.print(" \nINSERINDO CLIENTES\n");
                                cliente.cadastrarCliente();
                            }
                                break;
                            case 2: {
                                System.out.print(" \nALTERANDO CLIENTES\n");
                                cliente.alterarCliente();
                            }
                                break;
                            case 3: {
                                System.out.print(" \nEXCLUINDO CLIENTES\n");
                                cliente.excluirCliente();
                            }
                                break;
                            case 4: {
                                System.out.print(" \nALTERANDO CLIENTES\n");
                                cliente.alterarCliente();
                            }
                                break;
                        }
                    } while (op3 != 0);
                    break;
                }
                case 3: {
                    do {
                        op4 = menu4();

                        switch (op4) {
                            case 1: {
                                System.out.print(" \nINSERINDO COMPRA\n");
                                compra.cadastrarCompra();
                            }
                                break;
                            case 2: {
                                System.out.print(" \nEXCLUINDO COMPRA\n");
                                compra.excluirCompra();
                            }
                                break;
                        }

                    } while (op4 != 0);
                    break;
                }

                case 4: {
                    do {
                        op5 = menu5();

                        switch (op5) {
                            case 1: {
                                System.out.print(" \nINSERINDO VENDA\n");
                                venda.cadastrarVenda();
                            }
                                break;
                            case 3: {
                                System.out.print(" \nEXCLUINDO PRODUTO\n");
                                venda.excluirVenda();
                            }
                                break;
                        }

                    } while (op5 != 0);
                    break;
                }
            }
        } while (op != 0);
    }
}
