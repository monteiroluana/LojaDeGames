package br.com.lojaGame.db.dao;

import br.com.lojaGame.db.utils.ConnectionUtils;
import br.com.lojaGame.models.ItemVenda;
import br.com.lojaGame.models.Venda;
import br.com.lojaGame.models.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoVenda {

    public static int chaveGerada = 0;

    public static void inserir(Venda venda) throws SQLException, Exception {
        //Monta a String de 'INSERT' no DB;
        String sql = "INSERT INTO venda (idCliente, dataCompra, valorVenda) VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statement para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, venda.getIdCliente());
            Timestamp dataCom = new Timestamp(venda.getData().getTime());
            preparedStatement.setTimestamp(2, dataCom);
            preparedStatement.setFloat(3,venda.getValorTotal());

            //Executa o comando no banco de dados;
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                chaveGerada = rs.getInt(1);
            }
            inserirItens(venda.getCart());
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

    public static void inserirItens(List<ItemVenda> itensVenda) throws SQLException, Exception {

//        ArrayList <ItemCart> item = new ArrayList<>();
        for (ItemVenda item : itensVenda) {

            //Monta a String de 'INSERT' de um item no DB;
            String sql = "INSERT INTO itensVenda (idVenda, idProduto, qtdProd, valorTotal) VALUES (?, ?, ?, ?)";

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                //Abre a conexão com o banco 
                connection = ConnectionUtils.getConnetion();
                //Cria um Statment para executar as instruções sql
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, chaveGerada);
                preparedStatement.setInt(2, item.getIdProd());
                preparedStatement.setInt(3, item.getQntdCompra());
                preparedStatement.setFloat(4, item.getValor());

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
    }

    public static List<Relatorio> listarVendas(Date dataInicial, Date dataFinal) throws SQLException, Exception {
        //Monta a String de 'SELECT' de no DB;
        String sql = "SELECT v.idVenda AS Venda, c.nome AS Cliente, prod.nome AS Jogo, prod.preco AS Preco, "
                + "plat.descricao AS Plataforma, i.qtdProd AS Qtde, i.valorTotal AS vTotal, v.valorVenda,v.dataCompra AS dtCompra "
                + "FROM cliente c INNER JOIN venda v ON c.idCliente = v.idCliente "
                + "INNER JOIN itensVenda i ON v.idVenda = i.idVenda "
                + "INNER JOIN produto prod on i.idProduto = prod.idProduto "
                + "INNER JOIN plataforma plat ON prod.idPlataforma = plat.idPlataforma WHERE v.dataCompra BETWEEN ? and ? ORDER BY v.idVenda";
        //Lista  de resultado
        List<Relatorio> listaRelatorio = null;
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

            java.util.Date dtIni = dataInicial;
            java.sql.Date dIni = new java.sql.Date(dtIni.getTime());
            java.util.Date dtFin = dataFinal;
            java.sql.Date dFin = new java.sql.Date(dtFin.getTime());

            preparedStatement.setDate(1, dIni);
            preparedStatement.setDate(2, dFin);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaRelatorio == null) {
                    listaRelatorio = new ArrayList<Relatorio>();
                }
                //Cria uma instância de e popula com os valores do BD
                Relatorio relatorio = new Relatorio();

                relatorio.setIdVenda(result.getInt("Venda"));
                relatorio.setNomeCliente(result.getString("Cliente"));
                relatorio.setNomeJogo(result.getString("Jogo"));
                relatorio.setPreco(result.getFloat("Preco"));
                relatorio.setPlataforma(result.getString("Plataforma"));
                relatorio.setQuantidade(result.getInt("Qtde"));
                relatorio.setValorCompra(result.getFloat("vTotal"));
                Date d = new Date(result.getTimestamp("dtCompra").getTime());
                relatorio.setDataCompra(d);
                relatorio.setValorVenda(result.getFloat("valorVenda"));

                //Adiciona a instância na lista
                listaRelatorio.add(relatorio);
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
        //Retorna a lista do banco de dados
        return listaRelatorio;
    }
}
