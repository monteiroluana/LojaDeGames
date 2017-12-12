package br.com.lojaGame.services;

import br.com.lojaGame.db.dao.DaoVenda;
import br.com.lojaGame.exceptions.DataSourceException;
import br.com.lojaGame.exceptions.ItemCartException;
import br.com.lojaGame.exceptions.RelatorioException;
import br.com.lojaGame.model.validadores.ValidadorRelatorio;
import br.com.lojaGame.models.Relatorio;
import br.com.lojaGame.models.Venda;
import java.util.Date;
import java.util.List;

public class ServicoVenda {

    public static void cadastrarVenda(Venda venda)
            throws RelatorioException, DataSourceException, ItemCartException {

        try {
            DaoVenda.inserir(venda);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }
    }

    public static List<Relatorio> procurarVenda(Date dataInicial, Date dataFinal)
            throws RelatorioException, DataSourceException, Exception {
        
        ValidadorRelatorio.validarDatas(dataInicial, dataFinal);

        try {
            return DaoVenda.listarVendas(dataInicial, dataFinal);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

}
