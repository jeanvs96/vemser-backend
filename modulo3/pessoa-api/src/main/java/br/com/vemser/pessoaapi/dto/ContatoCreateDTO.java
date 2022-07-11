package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoContato;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoCreateDTO {

    private Integer idPessoa;
    @NotNull(message = "Informe o tipo de contato")
    private TipoContato tipoContato;
    @NotEmpty(message = "Informe o número")
    @Size(max = 13, message = "Informe um número válido")
    private String numero;
    @NotEmpty
    private String descricao;
}
