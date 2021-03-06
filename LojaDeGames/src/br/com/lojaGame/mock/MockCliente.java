package br.com.lojaGame.mock;

import java.util.ArrayList;
import java.util.List;
import br.com.lojaGame.models.Cliente;


public class MockCliente {

    private static int totalClientes = 0;
    /**
     * Armazena a lista de clientes inseridos para manipulação. #MOCK *
     */
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();

    //Insere um cliente no mock "cliente"
    public static void inserir(Cliente cliente)
            throws Exception {
        cliente.setIdCliente(totalClientes++);
        listaClientes.add(cliente);
    }

    //Realiza a atualização dos dados de um cliente, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Cliente"
    public static void atualizar(Cliente clienteProcura)
            throws Exception {
        if (clienteProcura != null && clienteProcura.getIdCliente() != null && !listaClientes.isEmpty()) {
            for (Cliente clienteLi : listaClientes) {
                if (clienteLi != null && clienteLi.getIdCliente() == clienteProcura.getIdCliente()) {
                    //clienteLi.setIdCliente(clienteProcura);
                    clienteLi.setNome(clienteProcura.getNome());
                    clienteLi.setCPF(clienteProcura.getCPF());
                    clienteLi.setRG(clienteProcura.getRG());
                    clienteLi.setSexo(clienteProcura.getSexo());
                    clienteLi.setDataNasc(clienteProcura.getDataNasc());
                    clienteLi.setEstadoCivil(clienteProcura.getEstadoCivil());
                    clienteLi.setCep(clienteProcura.getCep());
                    clienteLi.setLogradouro(clienteProcura.getLogradouro());
                    clienteLi.setNumero(clienteProcura.getNumero());
                    clienteLi.setComplemento(clienteProcura.getComplemento());
                    clienteLi.setBairro(clienteProcura.getBairro());
                    clienteLi.setCidade(clienteProcura.getCidade());
                    clienteLi.setUF(clienteProcura.getUF());
                    clienteLi.setTelefone(clienteProcura.getTelefone());
                    clienteLi.setEmail(clienteProcura.getEmail());
                    break;
                }
            }
        }
    }

    //Realiza a exclusão de um cliente no mock, com ID fornecido
    //como parâmetro.
    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente clienteLi = listaClientes.get(i);
                if (clienteLi != null && clienteLi.getIdCliente() == id) {
                    listaClientes.remove(i);
                    break;
                }
            }
        }
    }

    //Lista todos os clientes
    public static List<Cliente> listar()
            throws Exception {
        //Retorna a lista de clientes
        return listaClientes;
    }

    //Procura um cliente no mock, de acordo com o nome
    //ou com o CPF, passado como parâmetro
    public static List<Cliente> procurar(String valor)
            throws Exception {
        List<Cliente> listaResultado = new ArrayList<Cliente>();

        if (valor != null && !listaClientes.isEmpty()) {
            for (Cliente clienteLi : listaClientes) {
                if (clienteLi != null && clienteLi.getNome() != null
                        && clienteLi.getCPF() != null) {

                    //depois da modificação do tipo de dado do cpf (no model.cliente)
                    String CPF = clienteLi.getCPF();
                    if (clienteLi.getNome().toUpperCase().contains(valor.toUpperCase())
                            || CPF.contains(valor.toUpperCase())) {
                        listaResultado.add(clienteLi);
                        /*if (clienteLi.getNome().toUpperCase().contains(valor.toUpperCase())
                         || clienteLi.getSobrenome().toUpperCase().contains(valor.toUpperCase())) {
                         listaResultado.add(clienteLi);*/
                    }
                }
            }
        }

        //Retorna a lista de clientes encontrados
        return listaResultado;
    }

    //Obtém um cliente da lista
    public static Cliente obter(Integer id)
            throws Exception {
        if (id != null && !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i) != null && listaClientes.get(i).getIdCliente() == id) {
                    return listaClientes.get(i);
                }
            }
        }
        return null;
    }
}
