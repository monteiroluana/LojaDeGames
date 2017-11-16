package br.com.lojaGame.services;

import br.com.lojaGame.exceptions.DataSourceException;
import br.com.lojaGame.exceptions.VendasException;
import br.com.lojaGame.mock.MockVenda;
import br.com.lojaGame.model.validadores.ValidadorVenda;
import br.com.lojaGame.models.Venda;

public class ServicoVenda {

    public static void cadastrarVenda(Venda venda)
            throws VendasException, DataSourceException {

        ValidadorVenda.validar(venda);

        try {

            MockVenda.inserir(venda);

        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }
    }
}
