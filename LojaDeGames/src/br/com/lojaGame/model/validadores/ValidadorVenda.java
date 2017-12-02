package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.VendasException;
import br.com.lojaGame.models.ItemCart;
import br.com.lojaGame.models.Venda;
import br.com.lojaGame.ui.venda.FormVenda;

public class ValidadorVenda {

    public static void validar(Venda venda) throws VendasException {
        System.out.println("Oiiii");
        System.out.println("+++"+venda.getNomeCliente());
        

//        if (venda == null || venda.getValorTotal() == 0) {
//            throw new VendasException("não tem venda!");
//
//       }
//        if (venda.getNomeCliente() == null || "".equals(venda.getNomeCliente())) {
//            throw new VendasException("não tem cliente!");
//        }

    }

}
