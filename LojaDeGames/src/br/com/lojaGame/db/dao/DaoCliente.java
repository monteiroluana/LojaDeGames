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
                + "dataNasc, sexo, cep, logradouro, numero, complemento, bairro, cidade, uf, enabled) "
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
//            Timestamp tDataNasc = new Timestamp(cliente.getDataNasc().getTime());
//            preparedStatement.setTimestamp(7, tDataNasc);
            preparedStatement.setString(7, "2015-05-01");
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
                + "dataNasc = ?, sexo = ?, cep = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?"
                + "WHERE (idCliente=?)";

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
//            preparedStatement.setString(7, "2015-05-01");
            preparedStatement.setString(8, cliente.getSexo());
            preparedStatement.setString(9, cliente.getCep());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getNumero());
            preparedStatement.setString(12, cliente.getComplemento());
            preparedStatement.setString(13, cliente.getBairro());
            preparedStatement.setString(14, cliente.getCidade());
            preparedStatement.setString(15, cliente.getUF());
            preparedStatement.setInt(16, cliente.getIdCliente());

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
        String sql = "UPDATE cliente SET enabled=? WHERE (idCliente=?) ";

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

        String sql = "SELECT * FROM cliente WHERE enabled = ?";
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
                cliente.setIdCliente(result.getInt("idCliente"));
                cliente.setNome(result.getString("nome"));
                cliente.setCPF(result.getString("cpf"));
                cliente.setRG(result.getString("rg"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstadoCivil(result.getString("estCivil"));

                Date d = new Date(result.getTimestamp("dataNasc").getTime());
                cliente.setDataNasc(d);

                cliente.setSexo(result.getString("sexo"));
                cliente.setCep(result.getString("cep"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setNumero(result.getString("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setUF(result.getString("uf"));

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

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnetion();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setBoolean(3, true);

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
                cliente.setIdCliente(result.getInt("idCliente"));
                cliente.setNome(result.getString("nome"));
                cliente.setCPF(result.getString("cpf"));
                cliente.setRG(result.getString("rg"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstadoCivil(result.getString("estCivil"));
                Date d = new Date(result.getTimestamp("dataNasc").getTime());
                cliente.setDataNasc(d);
                cliente.setSexo(result.getString("sexo"));
                cliente.setCep(result.getString("cep"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setNumero(result.getString("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setUF(result.getString("uf"));

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

    public static Cliente obter(Integer id) throws SQLException, Exception {

        String sql = "SELECT * FROM cliente WHERE (idCliente=? and enabled=?)";

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

            if (result.next()) {

                //Cria uma instância de Cliente e popula com os valores do BD
                Cliente cliente = new Cliente();
                cliente.setIdCliente(result.getInt("idCliente"));
                cliente.setNome(result.getString("nome"));
                cliente.setCPF(result.getString("cpf"));
                cliente.setRG(result.getString("rg"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstadoCivil(result.getString("estCivil"));
                Date d = new Date(result.getTimestamp("dataNasc").getTime());
                cliente.setDataNasc(d);
                cliente.setSexo(result.getString("sexo"));
                cliente.setCep(result.getString("cep"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setNumero(result.getString("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setUF(result.getString("uf"));

                //Retorna o cliente
                return cliente;
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

}
