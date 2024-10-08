package med.voll.API.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.API.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {

}
