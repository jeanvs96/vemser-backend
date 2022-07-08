package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.*;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    @NotNull(message = "Informe o tipo de contato")
    private TipoContato tipoContato;

    @NotEmpty(message = "Informe o número")
    @Size(max = 13, message = "Informe um número válido")
    private String numero;

    @NotEmpty
    private String descricao;

    public Contato() {
    }

    public Contato(Integer idContato, Integer idPessoa, TipoContato tipoContato, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
