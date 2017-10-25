/*package br.com.lojaGame.model.clientes;*/

import java.util.Date;

public class Cliente {

    private String nome;
    private Integer cpf;
    private Integer rg;
    private String sexo;
    private Date dataNasc;
    private String estadoCivil;
    private Integer cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Integer telefone;
    private String email;
    private Integer idCliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCPF() {
        return cpf;
    }

    public void setCPF(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRG() {
        return rg;
    }

    public void setRG(Integer rg) {
        this.RG = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNascimento(Date dataNasc) {
        this.dataNasc = dataNasc;

    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogadouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String Complemento) {
        this.complemento = Complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return uf;
    }

    public void setUF(String uf) {
        this.uf = uf;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getemail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return idCliente;
    }

    public void setId(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
