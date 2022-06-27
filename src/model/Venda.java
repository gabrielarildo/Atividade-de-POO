/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class Venda {

    private int nrNF;
    private Date data;
    private String formaPagto;

    public Venda() {
    }

    public Venda(int nrNF, Date data, String formaPagto) {
        this.nrNF = nrNF;
        this.data = data;
        this.formaPagto = formaPagto;
    }

    public int getNrNF() {
        return nrNF;
    }

    public void setNrNF(int nrNF) {
        this.nrNF = nrNF;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(String formaPagto) {
        this.formaPagto = formaPagto;
    }

}
