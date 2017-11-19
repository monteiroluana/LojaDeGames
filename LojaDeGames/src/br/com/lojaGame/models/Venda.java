package br.com.lojaGame.models;

import br.com.lojaGame.models.Cliente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Venda {

    private Integer idVenda;
    private Cliente cliente;
    private ArrayList<ItemCart> Cart;
    private Date data;

    public Venda() {
        Cart = new ArrayList<ItemCart>();
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public String getCliente() {
        return cliente.getCPF();
    }

    public void setCliente(Object cliente) {
        this.cliente = (Cliente) cliente;
    }

    public void adicionarItem(ItemCart item) {
        Cart.add(item);
    }

    public void setData() {
        data = new Date();
    }

    public Date getData() {
        return data;
    }

    public float calcularValorTotal() {
        float total = 0.0f;
        for (ItemCart item : Cart) {
            total += item.calcularItem();
        }
        return total;
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
