package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.VendasException;
import br.com.lojaGame.models.ItemVenda;
import br.com.lojaGame.models.Venda;
import java.util.List;

public class ValidadorVenda {

    public static void validar(Venda venda, List <ItemVenda> itensVenda) throws VendasException {
        for (ItemVenda item : itensVenda) {
            if (item.getQntdEstoque() <= item.getQntdCompra()) {
                throw new VendasException("Produto " + item.getNomeProd() + " com estoque insuficiente. " + item.getQntdEstoque() + " unidades disponíveis");
            }
        }
    }
}
