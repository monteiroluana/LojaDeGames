package br.com.lojaGame.model.validadores;

import br.com.lojaGame.db.dao.DaoProduto;
import br.com.lojaGame.exceptions.ProdutosException;
import br.com.lojaGame.models.Produto;

public class ValidadorProduto {

    public static void validar(Produto produto) throws ProdutosException, Exception {
        if (produto == null) {
            throw new ProdutosException("Não foi informado um produto");
        }
        if (produto.getNome() == null || "".equals(produto.getNome())) {
            throw new ProdutosException("É necessário informar o nome do jogo");
        }
        if (produto.getCodBarras() == null || "".equals(produto.getCodBarras().trim())) {
            throw new ProdutosException("Campo estoque está vazio");
        }
        if (DaoProduto.obterIdentificador(produto.getCodBarras())) {
            throw new ProdutosException("Produto já cadastrado!");
        }
        if (produto.getCategoria() == null || "Selecione...".equals(produto.getCategoria())) {
            throw new ProdutosException("É necessário informar a categoria do jogo");
        }
        if (produto.getPlataforma() == null || "Selecione".equals(produto.getPlataforma())) {
            throw new ProdutosException("É necessário informar a plataforma do jogo");
        }
        if (produto.getFaixaEtaria() == null || "Selecione".equals(produto.getFaixaEtaria())) {
            throw new ProdutosException("É necessário informar a faixa etária do jogo");
        }        
        if (produto.getPreco() == null || produto.getPreco() <= 0) {
            throw new ProdutosException("É necessário informar o preço do jogo");
        }        
        if (produto.getQtdEstoque() == null || produto.getQtdEstoque() < 0) {
            throw new ProdutosException("Campo estoque está vazio");
        }        
        //teste
        if ("Selecione".equals(produto.getQtdJogadores())){
            produto.setQtdJogadores(null);
        }
    }
}
