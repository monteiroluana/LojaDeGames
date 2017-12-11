package br.com.lojaGame.models;

import java.util.Date;

public class Relatorio {

     private Integer idVenda;
    private String nomeCliente;
    private String nomeJogo;
    private String plataforma;
    private Float preco;
    private Integer quantidade;
    private Float valorCompra;
    private Date dataCompra;
    
    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    
    public String getNomeCliente() {
        return nomeCliente;
    }

   
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

   
    public String getNomeJogo() {
        return nomeJogo;
    }

    
    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

   
    public String getPlataforma() {
        return plataforma;
    }

    
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

   
    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

  
    public Integer getQuantidade() {
        return quantidade;
    }

  
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

   
    public Float getValorCompra() {
        return valorCompra;
    }

   
    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

   
    public Date getDataCompra() {
        return dataCompra;
    }

  
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
  
}
