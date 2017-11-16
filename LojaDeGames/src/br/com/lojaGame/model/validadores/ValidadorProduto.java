package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.ProdutosException;
import br.com.lojaGame.models.Produto;

public class ValidadorProduto {
    
    public static void validar(Produto produto) throws ProdutosException {
        if (produto == null) {
            throw new ProdutosException("Não foi informado um produto");
        }
        if (produto.getNome() == null || "".equals(produto.getNome())) {
            throw new ProdutosException("É necessário informar o nome do jogo");
        }
        if (produto.getCategoria() == null || "".equals(produto.getCategoria())) {
            throw new ProdutosException("É necessário informar a categoria do jogo");
        }
        if (produto.getPlataforma() == null || "".equals(produto.getPlataforma())) {
            throw new ProdutosException("É necessário informar a plataforma do jogo");
        }
        
        if (produto.getPreco() == null) {
            throw new ProdutosException("É necessário informar o preço do jogo");
        }
        if (produto.getFaixaEtaria() == null) {
            throw new ProdutosException("É necessário informar a faixa etária do jogo");
        }
    }
}
