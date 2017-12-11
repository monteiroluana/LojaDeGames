package br.com.lojaGame.models;

import java.util.ArrayList;
import java.util.Date;


public class Venda {

    private Integer idVenda;
    private Cliente cliente;
    private ArrayList<ItemVenda> Cart;
    private Date data;
    private float valorTotal = 0.00f;
    public int itens = 0;

    public Venda() {
        Cart = new ArrayList<ItemVenda>();
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

    public Integer getIdCliente() {
        return cliente.getIdCliente();
    }

    public void setCliente(Object cliente) {
        this.cliente = (Cliente) cliente;
    }

    public void addItem(ItemVenda item) {
        Cart.add(item);
        itens++;
    }

    public void deleteItem(Integer idItemCart) {
        for (ItemVenda item : Cart) {
            if (item.getIdProd() == idItemCart) {
                valorTotal -= item.getValor();
//                item.ajustarEstqCancel();
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
    public ArrayList<ItemVenda> getCart() {
        return Cart;
    }

    public void setCart(ArrayList<ItemVenda> Cart) {
        this.Cart = Cart;
    }

    //Ajustando o estoque
    public void ajusteEstoque(Integer idProd) {
        for (ItemVenda item : Cart) {
            if (item.getIdProd() == idProd) {
                item.ajustarEstq();
                break;
            }
        }
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
