package br.com.lojaGame.models;

import br.com.lojaGame.models.Cliente;
import java.util.ArrayList;

public class Cart {

    //ArrayList Cart vai receber Itens do Cart
    private ArrayList<ItemCart> Cart;

    public Cart() {
        Cart = new ArrayList<ItemCart>();
    }

    public void adicionarItem(ItemCart item) {
        Cart.add(item);
    }

    public float calcularValorTotal() {
        float total = 0.0f;
        for (ItemCart item : Cart) {
            total += item.calcularItem();
        }
        return total;
    }

}
