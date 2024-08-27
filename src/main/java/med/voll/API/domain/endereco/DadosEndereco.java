package med.voll.API.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8,9}", message = "O campo cep deve possuir de 8 a 9 digitos")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,

        String numero,

        String complemento) {

}
