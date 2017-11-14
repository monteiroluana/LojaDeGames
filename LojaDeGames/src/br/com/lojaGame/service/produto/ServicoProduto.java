package br.com.lojaGame.service.produto;

import br.com.lojaGame.exceptions.ProdutosException;
import br.com.lojaGame.exceptions.DataSourceException;
import br.com.lojaGame.mock.MockProduto;
import br.com.lojaGame.model.validador.produto.ValidadorProduto;
import br.com.lojaGame.model.produto.Produto;
import java.util.List;

public class ServicoProduto {

    public static void cadastrarProduto(Produto produto)
            throws DataSourceException, ProdutosException {

        ValidadorProduto.validar(produto);

        try {
            MockProduto.inserir(produto);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }

    }

    public static void atualizarProduto(Produto produto)
            throws DataSourceException, ProdutosException {

        ValidadorProduto.validar(produto);

        try {

            MockProduto.atualizar(produto);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }
    }

    public static List<Produto> procurarProduto(String nomeProduto)
            throws DataSourceException, ProdutosException {

        try {

//                if (nomeProduto == null || "".equals(nomeProduto)) {
//                    return MockProduto.listar();
//                } else {
//                    return MockProduto.procurar(nomeProduto);
//                }

           //lógica invertida
            if (nomeProduto != null || !"".equals(nomeProduto)) {
                return MockProduto.procurar(nomeProduto);
            } else {
                return MockProduto.listar();                
            }

        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }

    }

    public static Produto obterProduto(int id)
            throws DataSourceException, ProdutosException {

        try {

            return MockProduto.obter(id);

        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }

    }

    public static void excluirProduto(int id)
            throws DataSourceException, ProdutosException {

        try {

            MockProduto.excluir(id);

        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }

    }
}
