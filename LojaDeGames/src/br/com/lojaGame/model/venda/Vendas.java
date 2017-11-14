/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaGame.model.venda;

import br.com.lojaGame.model.cliente.Cliente;

/**
 *
 * @author luana.mpereira5
 */
public class Vendas {

    /**
     * @return the Cart
     */
    private Integer idVenda;
    private Cart cart;
    private Cliente cliente;

    public Vendas(Cart cart, Cliente cliente) {
        this.cart = cart;
        this.cliente = cliente;
    }

    public void setIdVenda(int idVend) {
        idVenda++;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart Cart) {
        this.cart = Cart;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
