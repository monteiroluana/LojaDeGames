package br.com.lojaGame.model.validador.cliente;

import br.com.lojaGame.exceptions.ClientesException;
import br.com.lojaGame.model.cliente.Cliente;

public class ValidadorCliente {

    public static void validar(Cliente cliente) throws ClientesException {

        if (cliente == null) {
            throw new ClientesException("Não foi informado um cliente");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClientesException("É necessário informar o nome do cliente");
        }
        if (cliente.getCPF() == null|| "".equals(cliente.getCPF())) {
            throw new ClientesException("E necessario informar o CPF");
        }
        if (cliente.getRG() == null|| "".equals(cliente.getRG())) {
            throw new ClientesException("E necessario informar o RG");
        }
        if (cliente.getDataNasc() == null) {
            throw new ClientesException("E necessario informar data de nascimento");
        }
        if (cliente.getCep() == null|| "".equals(cliente.getCep())) {
            throw new ClientesException("E necessario informar o CPF");
        }
        if (cliente.getLogradouro() == null || "".equals(cliente.getLogradouro())) {
            throw new ClientesException("E necessario informar o nome da Rua");
        }
        if (cliente.getNumero() == null) {
            throw new ClientesException("E necessario informar o numero do local");
        }
        if (cliente.getTelefone() == null|| "".equals(cliente.getTelefone())) {
            throw new ClientesException("E necessario informar um telefone para contato");
        }
        if (cliente.getEmail() == null || "".equals(cliente.getEmail())) {
            throw new ClientesException("E necessario informar um email");
        }
    }

}
