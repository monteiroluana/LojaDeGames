package br.com.lojaGame.services;

import br.com.lojaGame.db.dao.DaoProduto;
import br.com.lojaGame.exceptions.ProdutosException;
import br.com.lojaGame.exceptions.DataSourceException;
import br.com.lojaGame.mock.MockProduto;
import br.com.lojaGame.model.validadores.ValidadorProduto;
import br.com.lojaGame.models.Produto;
import java.util.List;

public class ServicoProduto {

    public static void cadastrarProduto(Produto produto)
            throws DataSourceException, ProdutosException {

        ValidadorProduto.validar(produto);

        try {
            //MockProduto.inserir(produto);
            DaoProduto.inserir(produto);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }

    }

    public static void atualizarProduto(Produto produto)
            throws DataSourceException, ProdutosException {

        ValidadorProduto.validar(produto);

        try {

            //MockProduto.atualizar(produto);
            DaoProduto.atualizar(produto);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }
    }

    public static List<Produto> procurarProduto(String nomeProduto)
            throws DataSourceException, ProdutosException {

        try {

            if (nomeProduto == null || "".equals(nomeProduto)) {
                // return MockProduto.listar();
                return DaoProduto.listar();
            } else {
                //return MockProduto.procurar(nomeProduto);
               return  DaoProduto.procurar(nomeProduto);
            }

        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }

    }

    public static Produto obterProduto(int id)
            throws DataSourceException, ProdutosException {

        try {

            //return MockProduto.obter(id);
            return DaoProduto.obter(id);

        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }

    }

    public static void excluirProduto(int id)
            throws DataSourceException, ProdutosException {

        try {

           // MockProduto.excluir(id);
           DaoProduto.excluir(id);

        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }

    }
}
