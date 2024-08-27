package med.voll.API.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    //Handling the NotFound exception
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    //Handling the ArgumentNotValid exception so it gives back only the field and the message why it is incorrect
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){

        var erro = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erro.stream().map(DadosCamposErrados::new).toList());
    }

    //DTO to get only the field and error message
    public record DadosCamposErrados(String campo, String menssagem){

        public DadosCamposErrados(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }

    }

}
