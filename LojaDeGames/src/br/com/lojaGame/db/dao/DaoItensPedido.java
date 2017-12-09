package br.com.lojaGame.db.dao;

import br.com.lojaGame.db.utils.ConnectionUtils;
import br.com.lojaGame.models.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoItensPedido {

    /* Insere um cliente na tabela clinte*/
    public static void inserir(ItemVenda itensVenda) throws SQLException, Exception {
        //Monta a String de 'INSERT' de um cliente no DB;
        String sql = "INSERT INTO itensVenda (idVenda, idProduto, qtdProd, valorTotal) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
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
