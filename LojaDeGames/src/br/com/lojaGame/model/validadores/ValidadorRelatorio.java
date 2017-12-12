package br.com.lojaGame.model.validadores;

import br.com.lojaGame.exceptions.RelatorioException;
import java.util.Date;

public class ValidadorRelatorio {
    public static void validarDatas(Date dataInicial, Date dataFinal) throws RelatorioException, Exception {
        //calcula a diferença de diaS
        long diferencaDias = (dataFinal.getTime() - dataInicial.getTime()) / (1000*60*60*24);
        
        if (diferencaDias < 0 || diferencaDias > 30) {
            throw new RelatorioException("Intervalo de datas inválido");
        }
    }
}
