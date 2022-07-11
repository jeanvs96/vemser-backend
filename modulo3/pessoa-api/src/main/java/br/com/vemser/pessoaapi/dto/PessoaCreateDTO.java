package br.com.vemser.pessoaapi.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaCreateDTO {

    @NotBlank(message = "Informe o nome")
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotBlank
    @Size(max = 11, min = 11, message = "O CPF deve conter somente 11 números.")
    private String cpf;
    @NotBlank
    private String email;
}
