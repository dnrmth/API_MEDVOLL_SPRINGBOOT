package med.voll.API.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.API.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {

}
