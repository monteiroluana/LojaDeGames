package br.com.lojaGame.db.dao;

import br.com.lojaGame.db.utils.ConnectionUtils;
import br.com.lojaGame.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto {

    public static void inserir(Produto produto) throws SQLException, Exception {
        //Monta a String de 'INSERT' de no DB;
        String sql = "INSERT INTO produto (nome, codBarra, categoria,  "
                + "desenv, preco, faixaEtaria, jogadores, qtdEstoque, idPlataforma, enabled) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getCodBarras());
            preparedStatement.setString(3, produto.getCategoria());
            preparedStatement.setString(4, produto.getDesenv());
            preparedStatement.setFloat(5, produto.getPreco());
            preparedStatement.setString(6, produto.getFaixaEtaria());
            preparedStatement.setString(7, produto.getQtdJogadores());
            preparedStatement.setInt(8, produto.getQtdEstoque());
            preparedStatement.setInt(9, produto.getPlataforma());
            preparedStatement.setBoolean(10, true);

            //configura os parâmetros do preparedStatement
            //Executa o comando no banco de dados;
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizar(Produto produto) throws SQLException, Exception {
        //Monta a String de 'UPDATE' no DB;
        String sql = "UPDATE produto SET  nome = ?, codBarra = ?, categoria = ?, desenv = ?,"
                + " preco = ?, faixaEtaria = ?, jogadores = ?, qtdEstoque = ?, idPlataforma  = ? "
                + " WHERE idProduto = ? ";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getCodBarras());
            preparedStatement.setString(3, produto.getCategoria());
            preparedStatement.setString(4, produto.getDesenv());
            preparedStatement.setFloat(5, produto.getPreco());
            preparedStatement.setString(6, produto.getFaixaEtaria());
            preparedStatement.setString(7, produto.getQtdJogadores());
            preparedStatement.setInt(8, produto.getQtdEstoque());
            preparedStatement.setInt(9, produto.getPlataforma());
            preparedStatement.setInt(10, produto.getIdProd());

            //Executa o comando no banco de dados;
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void excluir(Integer id) throws SQLException, Exception {
        //Monta a String de 'UPDATE' no DB;
        String sql = "UPDATE produto SET enabled = ? WHERE idProduto = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

            //Executa o comando no banco de dados;
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    /* Lista todos os produtos*/
    public static List<Produto> listar() throws SQLException, Exception {
          //Monta a String de 'SELECT' de no DB;
        String sql = "SELECT p.idProduto,p.nome,p.categoria,p.desenv,p.preco,p.codBarra,p.faixaEtaria,"
                + "p.jogadores,p.qtdEstoque, plat.descricao AS Plataforma FROM produto p "
                + "INNER JOIN plataforma plat on p.idPlataforma = plat.idPlataforma WHERE enabled = ?";
        //Lista de Produtos
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnetion();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
         
                Produto produto = new Produto();
                produto.setIdProd(result.getInt("idProduto"));
                produto.setNome(result.getString("nome"));
                produto.setCodBarras(result.getString("codBarra"));
                produto.setCategoria(result.getString("categoria"));
                produto.setDesenv(result.getString("desenv"));
                produto.setPreco(result.getFloat("preco"));
                produto.setFaixaEtaria(result.getString("faixaEtaria"));
                produto.setQtdJogadores(result.getString("jogadores"));
                produto.setQtdEstoque(result.getInt("qtdEstoque"));
              //  produto.setIdProd(result.getInt("idPlataforma"));
              produto.setStrPlataforma(result.getString("Plataforma"));
                /*
                nome, codBarra, categoria,  "
                + "desenv, preco, faixaEtaria, jogadores, qtdEstoque, idPlataforma, enabled
                 */ //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        return listaProdutos;
    }

    public static List<Produto> procurar(String search) throws SQLException, Exception {
        //Monta a String de 'SELECT' de no DB;
        String sql = "SELECT p.idProduto,p.nome,p.categoria,p.desenv,p.preco,p.codBarra,p.faixaEtaria,"
                + "p.jogadores,p.qtdEstoque, plat.descricao AS Plataforma FROM produto p "
                + "INNER JOIN plataforma plat on p.idPlataforma = plat.idPlataforma WHERE (UPPER(nome) LIKE UPPER(?) "
                + "OR UPPER(p.categoria) LIKE UPPER(?) OR UPPER(p.codBarra) LIKE UPPER(?) OR UPPER(plat.descricao) LIKE UPPER(?) AND enabled = ?)";
//        String sql = "SELECT * FROM produto WHERE (UPPER(nome) LIKE UPPER(?) AND enabled = ?)";
        //Lista de Produtos
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnetion();
            //Cria um preparedStatement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do PreparedStatement
             preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setString(3, "%" + search + "%");
            preparedStatement.setString(4, "%" + search + "%");
            preparedStatement.setBoolean(5, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                //Cria uma instância e popula com os valores do BD
                Produto produto = new Produto();
                produto.setIdProd(result.getInt("idProduto"));
                produto.setNome(result.getString("nome"));
                produto.setCodBarras(result.getString("codBarra"));
                produto.setCategoria(result.getString("categoria"));
                produto.setDesenv(result.getString("desenv"));
                produto.setPreco(result.getFloat("preco"));
                produto.setFaixaEtaria(result.getString("faixaEtaria"));
                produto.setQtdJogadores(result.getString("jogadores"));
                produto.setQtdEstoque(result.getInt("qtdEstoque"));
                produto.setStrPlataforma(result.getString("Plataforma"));
                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }

        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        return listaProdutos;
    }

    public static Produto obter(Integer id) throws SQLException, Exception {
        //Monta a String de 'SELECT' de no DB;
        String sql = "SELECT * FROM produto WHERE idProduto = ? AND enabled = ?";

        //Conexão para abertura e fechamento
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnetion();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Se a lista não foi inicializada, a inicializa
            if (result.next()) {
                //Cria uma instância de Cliente e popula com os valores do BD
                Produto produto = new Produto();
                produto.setIdProd(result.getInt("idProduto"));
                produto.setNome(result.getString("nome"));
                produto.setCategoria(result.getString("categoria"));
                produto.setPlataforma(result.getInt("idPlataforma"));
                produto.setDesenv(result.getString("desenv"));
                produto.setFaixaEtaria(result.getString("faixaEtaria"));
                produto.setQtdJogadores(result.getString("jogadores"));
                produto.setQtdEstoque(result.getInt("qtdEstoque"));
                produto.setPreco(result.getFloat("preco"));
                produto.setCodBarras(result.getString("codBarra"));

                //Retorna o produto
                return produto;
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Se o return anterior não foi executado
        return null;
    }
    
    public static boolean obterIdentificador(String codBarra) throws SQLException, Exception {
        //Monta a String de 'SELECT' de no DB;
        String sql = "SELECT * FROM produto WHERE codBarra = ? AND enabled = ?";

        //Conexão para abertura e fechamento
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnetion();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, codBarra);
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Se a lista não foi inicializada, a inicializa
            if (result.next()) {
               
                Produto produto = new Produto();
                produto.setIdProd(result.getInt("idProduto"));
                produto.setNome(result.getString("nome"));
                produto.setCategoria(result.getString("categoria"));
                produto.setPlataforma(result.getInt("idPlataforma"));
                produto.setDesenv(result.getString("desenv"));
                produto.setFaixaEtaria(result.getString("faixaEtaria"));
                produto.setQtdJogadores(result.getString("jogadores"));
                produto.setQtdEstoque(result.getInt("qtdEstoque"));
                produto.setPreco(result.getFloat("preco"));
                produto.setCodBarras(result.getString("codBarra"));

                //Retorna o produto
                return true;
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Se o return anterior não foi executado
        return false;
    }
}
