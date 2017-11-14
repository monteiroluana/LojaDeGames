
package br.com.lojaGame.model.venda;

import br.com.lojaGame.model.produto.Produto;

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
