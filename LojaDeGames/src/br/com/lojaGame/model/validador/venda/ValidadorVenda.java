package br.com.lojaGame.model.validador.venda;

import br.com.lojaGame.exceptions.VendasException;
import br.com.lojaGame.model.venda.Venda;

public class ValidadorVenda {

    public static void validar(Venda venda) throws VendasException {

        if (venda == null) {
            throw new VendasException("É necessário fazer uma venda!");
        }

    }
}
