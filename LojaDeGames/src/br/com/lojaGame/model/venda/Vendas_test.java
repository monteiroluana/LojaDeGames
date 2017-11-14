package br.com.lojaGame.model.venda;


/**
 *
 * @author nicolas.cmelo
 */
public class Vendas_test {

    private String nome;
    private String categoria;
    private String plataforma;
    private String fabricante;
    private Integer preço;
    private String faixaEtaria;
    private String jogadores;
    private Integer qntdEstoque;
    private Integer idProduto;
    
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
    
    public Integer getPreço() {
        return preço;
    }

    public void setPreço(Integer preço) {
        this.preço = preço;
    }
    public String getFaixaEtária() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    public String getJogadores() {
        return jogadores;
    }

    public void setJogadores(String jogadores) {
        this.jogadores = jogadores;
    }
    public Integer getQuantidadeEmEstoque() {
        return qntdEstoque;
    }

    public void setQuantidadeEmEstoque(Integer qntdEstoque) {
        this.qntdEstoque = qntdEstoque;
    }
    public Integer getIdProduto() {
        return idProduto;
    }

    public void setID(Integer idProduto) {
        this.idProduto = idProduto;
    }
}


