package br.com.lojaGame.models;

import br.com.lojaGame.models.Produto;

public class ItemCart {

    private Produto produto;
    private int quantidade;

    public ItemCart(Object jogo, int qtde) {
        produto = (Produto) jogo;
        quantidade = qtde;
    }

    public float calcularItem() {
        float valor = produto.getPreco() * quantidade;
        return valor;
    }

    public void ajustarEstq() {
        produto.setQtdEstoque(produto.getQtdEstoque() - quantidade);
    }

    public float unitario() {
        return produto.getPreco();
    }
    
    public Integer getIdProd(){
        return produto.getIdProd();
    }

}
