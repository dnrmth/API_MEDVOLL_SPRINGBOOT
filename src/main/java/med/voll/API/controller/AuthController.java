package med.voll.API.controller;


import jakarta.validation.Valid;
import med.voll.API.domain.usuario.DadosAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAuth dados){

        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var Authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
