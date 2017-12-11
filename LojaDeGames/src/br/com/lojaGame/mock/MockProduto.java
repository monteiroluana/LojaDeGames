package br.com.lojaGame.mock;

import java.util.ArrayList;
import java.util.List;
import br.com.lojaGame.models.Produto;

public class MockProduto {

//Mock de Produto. Realiza operações de mock com o produto
    private static int totalProdutos = 0;
    /**
     * Armazena a lista de produtos inseridos para manipulação. #MOCK *
     */
    private static List<Produto> listaProdutos = new ArrayList<Produto>();

    //Insere um produto no mock "produto"
    public static void inserir(Produto produto)
            throws Exception {
        produto.setIdProd(totalProdutos++);
        listaProdutos.add(produto);
    }

    //Realiza a atualização dos dados de um produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Produto"
    public static void atualizar(Produto produtoProcura)
            throws Exception {
        if (produtoProcura != null && produtoProcura.getIdProd() != null && !listaProdutos.isEmpty()) {
            for (Produto produtoCli : listaProdutos) {
                if (produtoCli != null && produtoCli.getIdProd() == produtoProcura.getIdProd()) {
                    produtoCli.setNome(produtoProcura.getNome());
                    produtoCli.setCategoria(produtoProcura.getCategoria());
                    produtoCli.setDesenv(produtoProcura.getDesenv());
                    produtoCli.setPlataforma(produtoProcura.getPlataforma());
                    produtoCli.setPreco(produtoProcura.getPreco());
                    produtoCli.setFaixaEtaria(produtoProcura.getFaixaEtaria());
                    produtoCli.setQtdJogadores(produtoProcura.getQtdJogadores());
                    produtoCli.setQtdEstoque(produtoProcura.getQtdEstoque());
                    produtoCli.setCodBarras(produtoProcura.getCodBarras());

                    break;
                }
            }
        }
    }

    //Realiza a exclusão de um produto no mock, com ID fornecido
    //como parâmetro.
    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaProdutos.isEmpty()) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto produtoLi = listaProdutos.get(i);
                if (produtoLi != null && produtoLi.getIdProd() == id) {
                    listaProdutos.remove(i);
                    break;
                }
            }
        }
    }

    //Lista todos os jogos
    public static List<Produto> listar()
            throws Exception {
        //Retorna a lista de jogos 
        return listaProdutos;
    }

    //Procura um produto na lista, de acordo com o nome ou categoria ou plataforma
    //do jogo passado como parâmetro
    public static List<Produto> procurar(String valor)
            throws Exception {
        List<Produto> listaResultado = new ArrayList<Produto>();

        if (valor != null && !listaProdutos.isEmpty()) {
            for (Produto produtoLi : listaProdutos) {
                if (produtoLi != null && produtoLi.getNome() != null
                        && produtoLi.getCategoria() != null && produtoLi.getPlataforma() != null
                        && produtoLi.getCodBarras() != null) {
                    if (produtoLi.getNome().toUpperCase().contains(valor.toUpperCase())
                            || produtoLi.getCategoria().toUpperCase().contains(valor.toUpperCase())
//                            || produtoLi.getPlataforma().toUpperCase().contains(valor.toUpperCase())
                            || produtoLi.getCodBarras().toUpperCase().contains(valor.toUpperCase())) {
                        listaResultado.add(produtoLi);
                    }
                }
            }
        }

        //Retorna a lista de jogos encontrados
        return listaResultado;
    }

    //Obtém um produto da lista
    public static Produto obter(Integer id)
            throws Exception {
        if (id != null && !listaProdutos.isEmpty()) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (listaProdutos.get(i) != null && listaProdutos.get(i).getIdProd() == id) {
                    return listaProdutos.get(i);
                }
            }
        }
        return null;
    }
}
