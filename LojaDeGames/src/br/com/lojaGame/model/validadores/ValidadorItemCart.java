package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.ItemCartException;
import br.com.lojaGame.models.ItemCart;
import java.util.List;

public class ValidadorItemCart {

    public static void validar(List<ItemCart> itensCart) throws ItemCartException {

        for (int i = 0; i < itensCart.size(); i++) {
            ItemCart itemCart = itensCart.get(i);

            if (itemCart.getQntdEstoque() < itemCart.getQntdCompra()) {
                throw new ItemCartException("Não temos esssa quantidade do jogo "
                        + itemCart.getNomeProd() + " em estoque.\n"
                        + "Somente " + itemCart.getQntdEstoque() + " unidade(s)");
            }

        }
    }
}
