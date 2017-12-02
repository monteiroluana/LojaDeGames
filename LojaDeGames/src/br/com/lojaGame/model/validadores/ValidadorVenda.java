package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.ClientesException;
import br.com.lojaGame.exceptions.VendasException;
import br.com.lojaGame.models.ItemCart;
import br.com.lojaGame.models.Venda;
import br.com.lojaGame.ui.venda.FormVenda;
import java.util.List;
import javax.swing.JOptionPane;

public class ValidadorVenda {

        public static void validar(Venda venda) throws VendasException, ClientesException {
       
        if (venda.getNomeCliente() == null || "".equals(venda.getNomeCliente())) {
            throw new ClientesException("É necessário informar o nome do cliente");
        }

    }

}
