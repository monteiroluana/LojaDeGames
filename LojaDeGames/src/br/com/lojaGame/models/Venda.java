package br.com.lojaGame.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

    private Integer idVenda;
    private Cliente cliente;
    private ArrayList<ItemCart> Cart;
    private Date data;
    private float valorTotal = 0.00f;
    public List<ItemCart> getCart;
    public int itens = 0;

    public Venda() {
        Cart = new ArrayList<ItemCart>();
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }

    public void setCliente(Object cliente) {
        this.cliente = (Cliente) cliente;
    }

    public void addItem(ItemCart item) {
        Cart.add(item);
        itens++;
    }

    public void deleteItem(Integer idItemCart) {
        for (ItemCart item : Cart) {
            if (item.getIdProd() == idItemCart) {
                valorTotal -= item.getValor();
                Cart.remove(item);
                break;
            }
        }
    }

    public void setData() {
        data = new Date();
    }

    public Date getData() {
        return data;
    }

    public void setValorTotal(float total) {
        valorTotal = total;
    }

    public float getValorTotal() {
        return valorTotal;
    }

//    public void addDesconto(float desc) {
//        valorTotal -= desc;
//    }
    public ArrayList<ItemCart> getCart() {
        return Cart;
    }

    public void setCart(ArrayList<ItemCart> Cart) {
        this.Cart = Cart;
    }

    public int contItens() {
        return itens;
    }
//FABIO
//        Date dataRelatorio = new Date();
//        
//        //Usar campo formatado na tela
//        Date dataInicial = (Date) campoDataInicial.getValue();          
//        
//        Calendar calendarInicial = Calendar.getInstance();
//        
//        calendarInicial.setTime(dataInicial);
//        
//        calendarInicial.set(Calendar.HOUR, 0);
//        calendarInicial.set(Calendar.MINUTE, 0);
//        calendarInicial.set(Calendar.SECOND, 0);
//        calendarInicial.set(Calendar.MILLISECOND, 0);
//                
//        
//        //Usar campo formatado na tela
//        Date dataFinal = (Date) campoDataFinal.getValue(); 
//        
//        Calendar calendarFinal = Calendar.getInstance();        
//        calendarFinal.setTime(dataFinal);
//        
//        calendarFinal.set(Calendar.HOUR, 23);
//        calendarFinal.set(Calendar.MINUTE, 59);
//        calendarFinal.set(Calendar.SECOND, 59);
//        calendarFinal.set(Calendar.MILLISECOND, 1000);
//        
//        
//        
//        if (calendarInicial.before(dataRelatorio) && calendarFinal.after(dataRelatorio)) {
//          
//        
//        }
//        
//
//        return data1 + hora1;
}
