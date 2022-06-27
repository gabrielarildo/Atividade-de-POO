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
public class Compra {

    private int nrCompra;
    private String fornecedor;
    private int quantComprada;
    private double valorCompra;

    public Compra() {
    }

    public Compra(int nrCompra, String fornecedor, int quantComprada, double valorCompra) {
        this.nrCompra = nrCompra;
        this.fornecedor = fornecedor;
        this.quantComprada = quantComprada;
        this.valorCompra = valorCompra;
    }

    public int getNrCompra() {
        return nrCompra;
    }

    public void setNrCompra(int nrCompra) {
        this.nrCompra = nrCompra;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantComprada() {
        return quantComprada;
    }

    public void setQuantComprada(int quantComprada) {
        this.quantComprada = quantComprada;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

}
