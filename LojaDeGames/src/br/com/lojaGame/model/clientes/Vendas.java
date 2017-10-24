package br.com.lojaGame.model.clientes;


/**
 *
 * @author nicolas.cmelo
 */
public class Vendas {

    private String nome;
    private String categoria;
    private String plataforma;
    private String fabricante;
    private Integer preço;
    private String faixaEtária;
    private String jogadores;
    private Integer quantidadeEmEstoque;
    private Integer ID;
    
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
        return faixaEtária;
    }

    public void setFaixaEtaria(String faixaEtária) {
        this.faixaEtária = faixaEtária;
    }
    public String getJogadores() {
        return jogadores;
    }

    public void setJogadores(String Jogadores) {
        this.jogadores = jogadores;
    }
    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer QuantidadeEmestoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public Integer getID() {
        return preço;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}


