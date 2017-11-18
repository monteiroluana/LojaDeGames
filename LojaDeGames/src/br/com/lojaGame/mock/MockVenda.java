package br.com.lojaGame.mock;

import br.com.lojaGame.models.Venda;
import java.text.SimpleDateFormat;
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

        //DATA INICIO*/
        Calendar calendarInicial = Calendar.getInstance();
        calendarInicial.setTime(dataInicial);

        calendarInicial.set(Calendar.HOUR_OF_DAY, 0);
        calendarInicial.set(Calendar.MINUTE, 0);
        calendarInicial.set(Calendar.SECOND, 0);
        calendarInicial.set(Calendar.MILLISECOND, 0);
        Date dtInit = new Date();
        dtInit = (calendarInicial.getTime());
        System.out.println("inicio: " + dtInit);
        /*~~~~~~~*/

        //DATA FINAL*/
        Calendar calendarFinal = Calendar.getInstance();
        calendarFinal.setTime(dataFinal);

        calendarFinal.set(Calendar.HOUR_OF_DAY, 23);
        calendarFinal.set(Calendar.MINUTE, 59);
        calendarFinal.set(Calendar.SECOND, 58);
        calendarFinal.set(Calendar.MILLISECOND, 1000);
        Date dtFinal = new Date();
        dtFinal = (calendarFinal.getTime());
        System.out.println("final: " + dtFinal);
        /*~~~~~~~*/

        for (Venda vendaLi : listaVendas) {
            Date comp = vendaLi.getData();

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String currDt = sdf.format(comp);
            if ((comp.after(dtInit)) && (comp.before(dtFinal)) || (currDt.equals(sdf.format(dtInit)) || currDt.equals(sdf.format(dtFinal)))) {
                System.out.println("Sayuri o if está funcionando (º 3º) ");
                listaResultado.add(vendaLi);
            } else {
                System.out.println("Sayuri o if não funiona ('¬ ¬) ");
            }
        }
        //Retorna a lista de vendas encontrados
        return listaResultado;
    }

}
