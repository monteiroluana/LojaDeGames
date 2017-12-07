package br.com.lojaGame.db.dao;

import br.com.lojaGame.db.utils.ConnectionUtils;
import br.com.lojaGame.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Data Access Object _ Cliente
public class DaoCliente {

    /* Insere um cliente na tabela clinte*/
    public static void inserir(Cliente cliente) throws SQLException, Exception {
        //Monta a String de 'INSERT' de um cliente no DB;
        String sql = "INSERT INTO cliente (nome, cpf, rg, email, telefone, estCivil, "
                + "dataNasc, sexo, cpe, logradouro, numero, complemento, bairro, cidade, uf, unabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.setString(3, cliente.getRG());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setString(5, cliente.getTelefone());
            preparedStatement.setString(6, cliente.getEstadoCivil());
            Timestamp tDataNasc = new Timestamp(cliente.getDataNasc().getTime());
            preparedStatement.setTimestamp(7, tDataNasc);
            preparedStatement.setString(8, cliente.getSexo());
            preparedStatement.setString(9, cliente.getCep());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getNumero());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getBairro());
            preparedStatement.setString(14, cliente.getCidade());
            preparedStatement.setString(15, cliente.getUF());
            preparedStatement.setBoolean(16, true);

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

    public static void atualizar(Cliente cliente) throws SQLException, Exception {
        //Monta a String de 'UPDATE' de um cliente no DB;
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, rg = ?, email = ?, telefone = ?, estCivil = ?, "
                + "dataNasc = ?, sexo = ?, cpe = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?"
                + "WHERE (cliente_id=?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.setString(3, cliente.getRG());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setString(5, cliente.getTelefone());
            preparedStatement.setString(6, cliente.getEstadoCivil());
            Timestamp tDataNasc = new Timestamp(cliente.getDataNasc().getTime());
            preparedStatement.setTimestamp(7, tDataNasc);
            preparedStatement.setString(8, cliente.getSexo());
            preparedStatement.setString(9, cliente.getCep());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getNumero());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getBairro());
            preparedStatement.setString(14, cliente.getCidade());
            preparedStatement.setString(15, cliente.getUF());

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

    /* "Exclui" um cliente da tabela cliente*/
    public static void excluir(Integer idCliente) throws SQLException, Exception {
        //Monta a String de 'DELETE' de um cliente no DB;
        String sql = "UPDATE cliente SET unabled=? WHERE (cliente_id=?) ";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Abre a conexão com o banco 
            connection = ConnectionUtils.getConnetion();
            //Cria um Statment para executar as instruções sql
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, idCliente);
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

    //Lista todos os clientes da tabela cliente
    public static List<Cliente> listar() throws SQLException, Exception {

        String sql = "SELECT * FROM cliente WHERE unable = ?";
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
            preparedStatement.setBoolean(1, true);

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
                cliente.setCPF(result.getString("cpf"));
                cliente.setRG(result.getString("rg"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstadoCivil(result.getString("estCivil"));
                Date d = new Date(result.getTimestamp("data_nasc").getTime());
                cliente.setDataNasc(d);
                

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
    
    /* Procura um cliente na tabela cliente*/
    public static List<Cliente> procurar(String search) throws SQLException, Exception {

        String sql = "SELECT * FROM cliente WHERE ((UPPER(nome) LIKE UPPER(?) "
            + "OR UPPER(cliente.cpf) LIKE UPPER(?)) AND enabled=?)";
        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;
        //Conexão para abertura e fechamento
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        preparedStatement.setString(1, sql);
        preparedStatement.setString(2, "%"+search+"%");
        preparedStatement.setString(3, "%"+search+"%");

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnetion();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);


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
                cliente.setRG(result.getString("id"));
                cliente.setSexo(result.getString("nome"));
                cliente.setEstadoCivil(result.getString("nome"));
                cliente.setEmail(result.getString("nome"));
                cliente.setTelefone(result.getString("nome"));
                cliente.setCep(result.getString("logradouro"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setBairro(result.getString("logradouro"));
                cliente.setCidade(result.getString("logradouro"));
                cliente.setUF(result.getString("logradouro"));
                cliente.setNumero(result.getString("logradouro"));
                cliente.setIdCliente(1);

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
