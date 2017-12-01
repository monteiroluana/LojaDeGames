package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.VendasException;
import br.com.lojaGame.models.Venda;
import br.com.lojaGame.ui.venda.FormVenda;

public class ValidadorVenda {

    public static void validar(Venda venda) throws VendasException {

        if (venda.getNomeCliente() == null) {
            throw new VendasException("É necessário informar um cliente!");
        }

        if (venda == null) {
            throw new VendasException("É necessário fazer uma venda!");

        }
    }
}
