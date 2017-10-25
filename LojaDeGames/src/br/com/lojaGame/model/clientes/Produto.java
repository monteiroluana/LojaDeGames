package br.com.lojaGame.model.clientes;


/**
 *
 * @author nicolas.cmelo
 */
import java.util.Date;

    public class Produto {
    private Integer idCliente;
    private String nome;
    private String produto;
    private String quantidade;
    private Integer desconto;
    private Date   dataInicio;
    private Date   dataFinal;
    
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    public Integer getDesconto() {
        return desconto;
    }

    public void setIdDesconto(Integer desconto) {
        this.desconto = desconto;
    }
    public Date getDataInício() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}

