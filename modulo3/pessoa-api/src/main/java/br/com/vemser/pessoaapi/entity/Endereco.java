package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
//    @NotNull(message = "Informe o tipo de endereço (COMERCIAL/RESIDENCIAL)")
    private TipoEndereco tipo;
//    @NotEmpty(message = "Informe um logradouro válido")
//    @Size(max = 250, message = "Informe um logradouro com até 250 carácteres")
    private String logradouro;
//    @NotNull(message = "Informe um número válido")
//    @Min(0)
    private Integer numero;
    private String complemento;
//    @NotEmpty(message = "Informe um CEP válido")
//    @Size(max = 8, min = 8, message = "O CEP deve conter somente 8 números")
    private String cep;
//    @NotEmpty(message = "Informe uma cidade válida")
//    @Size(max = 250, message = "Informe uma cidade com até 250 carácteres")
    private String cidade;
//    @NotNull(message = "Informe um estado")
    private String estado;
//    @NotNull(message = "Informe um país")
    private String pais;
}
