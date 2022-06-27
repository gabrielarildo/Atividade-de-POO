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
public class ItemVendido {

    private int qunatidadeVendida;
    private double precoVenda;

    public ItemVendido() {
    }

    public ItemVendido(int qunatidadeVendida, double precoVenda) {
        this.qunatidadeVendida = qunatidadeVendida;
        this.precoVenda = precoVenda;
    }

    public int getQunatidadeVendida() {
        return qunatidadeVendida;
    }

    public void setQunatidadeVendida(int qunatidadeVendida) {
        this.qunatidadeVendida = qunatidadeVendida;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

}
