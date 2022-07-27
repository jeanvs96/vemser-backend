package br.com.vemser.pessoaapi.enums;

public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private final Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

}
