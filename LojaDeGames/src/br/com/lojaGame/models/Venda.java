package br.com.lojaGame.models;

import br.com.lojaGame.models.Cliente;
import java.util.ArrayList;

public class Venda {

    private Integer idVenda;
    //ArrayList Cart vai receber Itens do Cart
    private ArrayList<ItemCart> Cart;
//    private Cliente cpfCliente;

    public Venda(Cart cart, Cliente cpfCliente) {
        Cart = new ArrayList<ItemCart>();
//        this.cpfCliente = cpfCliente;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
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
