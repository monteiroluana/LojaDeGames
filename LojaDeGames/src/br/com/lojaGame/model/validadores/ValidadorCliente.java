package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.ClientesException;
import br.com.lojaGame.models.Cliente;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorCliente {

    public static void validar(Cliente cliente) throws ClientesException {

        if (cliente == null) {
            throw new ClientesException("Não foi informado um cliente");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClientesException("É necessário informar o nome do cliente");
        }
        if (cliente.getCPF() == null || "".equals(cliente.getCPF())) {
            throw new ClientesException("É necessário informar o CPF");
        }
        if (cliente.getRG() == null || "".equals(cliente.getRG())) {
            throw new ClientesException("É necessário informar o RG");
        }
        if (cliente.getSexo() == null || "Selecione...".equals(cliente.getSexo())) {
            throw new ClientesException("É necessário informar o sexo");
        }       
        if (cliente.getCep() == null || "".equals(cliente.getCep())) {
            throw new ClientesException("É necessário informar o CEP");
        }
        if (cliente.getLogradouro() == null || "".equals(cliente.getLogradouro())) {
            throw new ClientesException("É necessário informar o nome da rua");
        }
        if (cliente.getNumero() == null) {
            throw new ClientesException("É necessário informar o número do local");
        }
        if (cliente.getTelefone() == null || "".equals(cliente.getTelefone())) {
            throw new ClientesException("É necessário informar um telefone para contato");
        }
        
        //Validando email
        if (cliente.getEmail() == null || "".equals(cliente.getEmail())) {
            throw new ClientesException("Campo email vazio");
        } else if (cliente.getEmail() != null && cliente.getEmail().length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cliente.getEmail());
            if (!matcher.matches()) {
                throw new ClientesException("Email inválido");
            }
        }
        
         //teste p/ não deixar o Selecione...
        if ("Selecione...".equals(cliente.getEstadoCivil())){
            cliente.setEstadoCivil(null);
        }

    }
}


