package br.com.lojaGame.service.cliente;

import br.com.lojaGame.exceptions.ClientesException;
import br.com.lojaGame.mock.MockCliente;
import br.com.lojaGame.exceptions.DataSourceException;
import br.com.lojaGame.model.cliente.Cliente;
import br.com.lojaGame.model.validador.cliente.ValidadorCliente;
import java.util.List;

public class ServicoCliente {

    public static void cadastrarCliente(Cliente cliente) 
        throws ClientesException, DataSourceException
        {

            ValidadorCliente.validar(cliente);

            try {

                MockCliente.inserir(cliente);

            } catch (Exception e) {

                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);

            }
        }
        
         

    

    public static void atualizarCliente(Cliente cliente) 
        throws ClientesException, DataSourceException
        {

            ValidadorCliente.validar(cliente);

            try {

                MockCliente.atualizar(cliente);
                return;

            } catch (Exception e) {

                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);

            }
        }
    

    
    public static List<Cliente> procurarCliente(String nome) 
        throws ClientesException, DataSourceException
        {

            try {
                if (nome == null || "".equals(nome)) {

                    return MockCliente.listar();
                } else {

                    return MockCliente.procurar(nome);
                }
            }
                catch(Exception e){
                    
                    e.printStackTrace();
                    throw new DataSourceException("Erro na fonte de dados", e);
                    }
            }
        
        

    public static Cliente obterCliente(int id) 
        throws ClientesException, DataSourceException
        {

            try {

                return MockCliente.obter(id);
            } catch (Exception e) {

                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
//teste
    

    public static void excluirCliente(int id) 
        throws ClientesException, DataSourceException
        {

            try {
                MockCliente.excluir(id);
            } catch (Exception e) {

                e.printStackTrace();
                throw new DataSourceException("Erro nda fonte de dados", e);
            }

        }      
        
                
    
}
    
 
    

