package br.com.emazureck.spring_jpa_mysql.controller;

import br.com.emazureck.spring_jpa_mysql.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/v1/usuarios")
public class UserController {

    private UserRepository usuarioRepositorio;

    public UserController(UserRepository usuarioRepositorio) {

        this.usuarioRepositorio = usuarioRepositorio;
    }

    //find all
    @GetMapping()
    public ResponseEntity getUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepositorio.findAll());
    }
}