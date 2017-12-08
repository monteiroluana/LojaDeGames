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
        
        //verificar se o cpf é válido    
//        } else {
//            String cpf = cliente.getCPF();
//
//            int n1 = Integer.parseInt(cpf.substring(0, 1));
//            int n2 = Integer.parseInt(cpf.substring(1, 2));
//            int n3 = Integer.parseInt(cpf.substring(2, 3));
//            int n4 = Integer.parseInt(cpf.substring(3, 4));
//            int n5 = Integer.parseInt(cpf.substring(4, 5));
//            int n6 = Integer.parseInt(cpf.substring(5, 6));
//            int n7 = Integer.parseInt(cpf.substring(6, 7));
//            int n8 = Integer.parseInt(cpf.substring(7, 8));
//            int n9 = Integer.parseInt(cpf.substring(8, 9));
//            int n10 = Integer.parseInt(cpf.substring(9, 10));
//            int n11 = Integer.parseInt(cpf.substring(10, 11));
//
//            int soma1 = (n1 * 10) + (n2 * 9) + (n3 * 8) + (n4 * 7) + (n5 * 6) + (n6 * 5) + (n7 * 4) + (n8 * 3) + (n9 * 2);
//            int restosoma1 = soma1 % 11;
//            int subt1 = 11 - restosoma1;
//
//            if (subt1 < 10 && subt1 == n10 || subt1 == 0) {
//                
//                int soma2 = (n1 * 11) + (n2 * 10) + (n3 * 9) + (n4 * 8) + (n5 * 7) + (n6 * 6) + (n7 * 5) + (n8 * 4) + (n9 * 3) + (n10 * 2);
//                int restosoma2 = soma2 % 11;
//                int subt2 = 11 - restosoma2;
//                if (subt2 < 10 && subt2 == n11 || subt2 == 0) {
//                    
//                } else {
//                    throw new ClientesException("CPF INVÁLIDO");
//                }
//            }
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
        if ("Selecione...".equals(cliente.getEstadoCivil())) {
            cliente.setEstadoCivil(null);
        }

    }
}
