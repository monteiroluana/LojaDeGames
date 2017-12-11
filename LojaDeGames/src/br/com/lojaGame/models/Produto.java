package br.com.lojaGame.models;

public class Produto {

    private Integer idProduto;
    private String nome;
    private String categoria;
    private Integer plataforma;
    private String desenv;
    private String faixaEtaria;
    private String qtdJogadores;
    private Integer qtdEstoque;
    private Float preco;
    private String codBarras;
    private String strPlataforma;

    public String getStrPlataforma() {
        return strPlataforma;
    }

    public void setStrPlataforma(String strPlataforma) {
        this.strPlataforma = strPlataforma;
    }

    public Integer getIdProd() {
        return idProduto;
    }

    public void setIdProd(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Integer plataforma) {
        this.plataforma = plataforma;
    }

    public String getDesenv() {
        return desenv;
    }

    public void setDesenv(String fabricante) {
        this.desenv = fabricante;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(String qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

}
