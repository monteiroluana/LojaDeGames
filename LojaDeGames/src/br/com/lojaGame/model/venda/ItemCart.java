/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaGame.model.venda;

import br.com.lojaGame.model.produto.Produto;

/**
 *
 * @author luana.mpereira5
 */
public class ItemCart {

    private Produto produto;
    private int quantidade;

    public ItemCart(Produto jogo, int qtde) {
        produto = jogo;
        quantidade = qtde;
    }

    public float calcularItem() {
        float valor = produto.getPreco() * quantidade;
        return valor;
    }

   
}
