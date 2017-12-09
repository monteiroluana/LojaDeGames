package br.com.lojaGame.db.dao;

import br.com.lojaGame.db.utils.ConnectionUtils;
import br.com.lojaGame.models.ItemVenda;
import br.com.lojaGame.models.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DaoVenda {

    public static int chaveGerada;

    public static void inserir(Venda venda) throws SQLException, Exception {
        //Monta a String de 'INSERT' de um cliente no DB;
        String sql = "INSERT INTO venda (idVenda, idCliente, dataCompra) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, venda.getIdVenda());
            preparedStatement.setInt(2, venda.getIdCliente());
            Timestamp dataCom = new Timestamp(venda.getData().getTime());
            preparedStatement.setTimestamp(3, dataCom);

            //Executa o comando no banco de dados;
            preparedStatement.execute();
            preparedStatement.getGeneratedKeys().next();
            chaveGerada=preparedStatement.getGeneratedKeys().getInt(1);
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

    public static void inserirItens(ItemVenda itensVenda) throws SQLException, Exception {
        //Monta a String de 'INSERT' de um cliente no DB;
        String sql = "INSERT INTO itensVenda (idVenda, idProduto, qtdProd, valorTotal) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, chaveGerada);
            preparedStatement.setInt(2, itensVenda.getIdProd());
            preparedStatement.setInt(3, itensVenda.getQntdCompra());
            preparedStatement.setFloat(4, 0);

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
