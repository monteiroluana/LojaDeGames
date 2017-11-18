package br.com.lojaGame.mock;

import br.com.lojaGame.models.Venda;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MockVenda {

    private static int totalVendas = 0;
    private static List<Venda> listaVendas = new ArrayList<Venda>();

    public static void inserir(Venda venda)
            throws Exception {
        venda.setIdVenda(totalVendas++);
        listaVendas.add(venda);
    }

    //Procura uma venda no mock, de acordo com as datas    
    public static List<Venda> procurar(Date dataInicial, Date dataFinal)
            throws Exception {
        List<Venda> listaResultado = new ArrayList<Venda>();

        System.out.println("cheguei aqui mock procurar ");

        Calendar calendarInicial = Calendar.getInstance();
        calendarInicial.setTime(dataInicial);

        calendarInicial.set(Calendar.HOUR, 0);
        calendarInicial.set(Calendar.MINUTE, 0);
        calendarInicial.set(Calendar.SECOND, 0);
        calendarInicial.set(Calendar.MILLISECOND, 0);

        Calendar calendarFinal = Calendar.getInstance();
        calendarFinal.setTime(dataFinal);

        calendarFinal.set(Calendar.HOUR, 23);
        calendarFinal.set(Calendar.MINUTE, 59);
        calendarFinal.set(Calendar.SECOND, 59);
        calendarFinal.set(Calendar.MILLISECOND, 1000);

        System.out.println("formRelatorio data inicial " + dataInicial);
        System.out.println("formRelatorio data final " + dataFinal);

        for (Venda vendaLi : listaVendas) {
            if (calendarInicial.before(vendaLi.getData()) && calendarFinal.after(vendaLi.getData())) {
                listaResultado.add(vendaLi);
                System.out.println("FOI");
            } else {
                System.out.println("NÃO FOI NADA!!");
            }
        }

        //Retorna a lista de vendas encontrados
        return listaResultado;
    }

}
