package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.ClientesException;
import br.com.lojaGame.models.Cliente;

public class ValidadorCliente {

    public static void validar(Cliente cliente) throws ClientesException {

        if (cliente == null) {
            throw new ClientesException("Não foi informado um cliente");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClientesException("É necessário informar o nome do cliente");
        }
        if (cliente.getCPF() == null|| "".equals(cliente.getCPF())) {
            throw new ClientesException("É necessário informar o CPF");
        }
        if (cliente.getRG() == null|| "".equals(cliente.getRG())) {
            throw new ClientesException("É necessário informar o RG");
        }
        if(cliente.getSexo() == null || "Selecione...".equals(cliente.getSexo())) {
            throw new ClientesException("É necessário informar o sexo");
        }
//        if (cliente.getDataNasc() == null) {
//            throw new ClientesException("É necessário informar data de nascimento");
//        }
        if (cliente.getCep() == null|| "".equals(cliente.getCep())) {
            throw new ClientesException("É necessário informar o CEP");
        }
        if (cliente.getLogradouro() == null || "".equals(cliente.getLogradouro())) {
            throw new ClientesException("É necessário informar o nome da rua");
        }
        if (cliente.getNumero() == null) {
            throw new ClientesException("É necessário informar o número do local");
        }
        if (cliente.getTelefone() == null|| "".equals(cliente.getTelefone())) {
            throw new ClientesException("É necessário informar um telefone para contato");
        }
        if (cliente.getEmail() == null || "".equals(cliente.getEmail())) {
            throw new ClientesException("É necessário informar um email");
        }
    }

}
