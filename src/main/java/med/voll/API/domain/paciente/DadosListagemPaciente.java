package med.voll.API.domain.paciente;

public record DadosListagemPaciente(String nome, String telefone, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.getCpf());
    }

}
