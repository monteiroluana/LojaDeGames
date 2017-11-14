
package br.com.lojaGame.model.venda;

import br.com.lojaGame.model.cliente.Cliente;

public class Vendas {

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
