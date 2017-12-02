package br.com.lojaGame.models;

import br.com.lojaGame.models.Produto;

public class ItemCart {

    private Produto produto;
    private int qntdCompra;
    private float valor;

    public ItemCart(Object jogo, int qtde) {
        produto = (Produto) jogo;
        qntdCompra = qtde;
        valor = produto.getPreco() * qntdCompra;

    }

    public float getValor() {
        return valor;
    }

    public void ajustarEstq() {
        produto.setQtdEstoque(produto.getQtdEstoque() - qntdCompra);
    }

    public void ajustarEstqCancel() {
        produto.setQtdEstoque(produto.getQtdEstoque() + qntdCompra);
    }

    public float getPrecoUnit() {
        return produto.getPreco();
    }

    public Integer getIdProd() {
        return produto.getIdProd();
    }

    public String getNomeProd() {
        return produto.getNome();
    }

    public Integer getQntdCompra() {
        return qntdCompra;
    }

    public Integer getQntdEstoque() {
        return produto.getQtdEstoque();
    }

}
