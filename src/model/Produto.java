/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabri
 */
public class Produto {

    private int codigo;
    private String descricao;
    private int quant;
    private double valorVenda;
    private double valorCusto;

    public Produto() {
    }

    public Produto(int codigo, String descricao, int quant, double valorVenda, double valorCusto) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quant = quant;
        this.valorVenda = valorVenda;
        this.valorCusto = valorCusto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

}
