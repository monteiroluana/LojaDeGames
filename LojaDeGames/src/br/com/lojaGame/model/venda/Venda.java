package br.com.lojaGame.model.venda;

import br.com.lojaGame.model.cliente.Cliente;

public class Venda {

    private Integer idVenda;
    private Cart cart;
//    private Cliente cpfCliente;

    public Venda(Cart cart, Cliente cpfCliente) {
        this.cart = cart;
//        this.cpfCliente = cpfCliente;
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
}
