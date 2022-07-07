package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull(message = "Informe o tipo de endereço (COMERCIAL/RESIDENCIAL)")
    private TipoEndereco tipo;
    @NotEmpty(message = "Informe um logradouro válido")
    @Size(max = 250, message = "Informe um logradouro com até 250 carácteres")
    private String logradouro;
    @NotEmpty(message = "Informe um número válido")
    private Integer numero;
    private String complemento;
    @NotEmpty(message = "Informe um CEP válido")
    @Size(max = 8, min = 8, message = "O CEP deve conter somente 8 números")
    private String cep;
    @NotEmpty(message = "Informe uma cidade válida")
    @Size(max = 250, message = "Informe uma cidade com até 250 carácteres")
    private String cidade;
    @NotNull(message = "Informe um estado")
    private String estado;
    @NotNull(message = "Informe um país")
    private String pais;

    public Endereco(Integer idEndereco, Integer idPessoa, TipoEndereco tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
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

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
