package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {

    private Integer idPessoa;
//    @NotBlank(message = "Informe o nome")
    private String nome;
//    @NotNull
//    @Past
    private LocalDate dataNascimento;
//    @NotBlank
//    @Size(max = 11, min = 11, message = "O CPF deve conter somente 11 números.")
    private String cpf;
    private String email;
}
