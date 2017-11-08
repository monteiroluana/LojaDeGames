package br.com.lojaGame.model.validador.produto;

import br.com.lojaGame.exceptions.ProdutosException;
import br.com.lojaGame.model.produto.Produto;

public class ValidadorProduto {
    
    public static void validar(Produto produto) throws ProdutosException {
        if (produto == null) {
            throw new ProdutosException("Nao foi informado um produto");
        }
        if (produto.getNome() == null || "".equals(produto.getNome())) {
            throw new ProdutosException("E necessario informar o nome do jogo");
        }
        if (produto.getCategoria() == null || "".equals(produto.getCategoria())) {
            throw new ProdutosException("E necessario informar a categoria do jogo");
        }
        if (produto.getPlataforma() == null || "".equals(produto.getPlataforma())) {
            throw new ProdutosException("E necessario informar a plataforma do jogo");
        }
        
        if (produto.getPreco() == null) {
            throw new ProdutosException("E necessario informar o preco do jogo");
        }
        if (produto.getFaixaEtaria() == null) {
            throw new ProdutosException("E necessario informar a faixa etaria do jogo");
        }
    }
}