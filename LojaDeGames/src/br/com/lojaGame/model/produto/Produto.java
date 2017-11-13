package br.com.lojaGame.model.produto;

/**
 *
 * @author nicolas.cmelo
 */
public class Produto {

    private Integer idProduto;
    private String nome;
    private String categoria;
    private String plataforma;
    private String fabricante;
    private String faixaEtaria;
    private String qtdJogadores;
    private Integer qtdEstoque;
    private Float preco;

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

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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

}
