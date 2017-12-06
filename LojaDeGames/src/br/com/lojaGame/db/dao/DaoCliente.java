package br.com.lojaGame.db.dao;

import br.com.lojaGame.db.utils.ConnectionUtils;
import br.com.lojaGame.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Data Access Object _ Cliente
public class DaoCliente {

    public static void inserir(Cliente cliente) throws SQLException, Exception {
        //Monta a String de 'INSERT' de um cliente no DB;
        String sql = "INSERT INTO cliente (id, nome, endereco) VALUES (?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getCPF());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getLogradouro());

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
    
    //Lista todos os clientes da tabela clientes
    public static List<Cliente> listar()
            throws SQLException, Exception {
   
        String sql = "SELECT * FROM cliente;";
        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;
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
//            preparedStatement.setBoolean(1, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                Cliente cliente = new Cliente();
                cliente.setNome(result.getString("nome"));
                cliente.setCPF(result.getString("id"));
                cliente.setRG(result.getString("nome"));
                cliente.setSexo(result.getString("nome"));
                cliente.setEstadoCivil(result.getString("nome"));
//                Date d = new Date(result.getTimestamp("nome").getTime());
                cliente.setEmail(result.getString("nome"));
                cliente.setTelefone(result.getString("nome"));
                cliente.setCep(result.getString("nome"));
                cliente.setLogradouro(result.getString("nome"));
                cliente.setBairro(result.getString("nome"));
                cliente.setCidade(result.getString("nome"));
                cliente.setUF(result.getString("nome"));
                
            
                //Adiciona a instância na lista
                listaClientes.add(cliente);
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
        return listaClientes;
    }
    

}
