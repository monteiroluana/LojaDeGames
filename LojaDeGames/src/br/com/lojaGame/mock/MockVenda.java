/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaGame.mock;


import br.com.lojaGame.model.venda.Vendas;
import java.util.ArrayList;
import java.util.List;

public class MockVenda {

    private static int totalVendas = 0;
    private static List<Vendas> listaVendas = new ArrayList<Vendas>();
   
    public static void inserir(Vendas venda)
            throws Exception {
        venda.setIdVenda(totalVendas++);
        listaVendas.add(venda);
    }
}
