package br.com.vemser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoDTO extends ContatoCreateDTO {

    private Integer idContato;
}
