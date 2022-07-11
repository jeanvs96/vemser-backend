package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
//    @NotNull(message = "Informe o tipo de contato")
    private TipoContato tipoContato;
//    @NotEmpty(message = "Informe o número")
//    @Size(max = 13, message = "Informe um número válido")
    private String numero;

//    @NotEmpty
    private String descricao;
}
