package br.com.vemser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaDTO extends PessoaCreateDTO{
    private Integer idPessoa;
}
