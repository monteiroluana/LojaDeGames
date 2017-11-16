
package br.com.lojaGame.models;

import br.com.lojaGame.models.Produto;

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
