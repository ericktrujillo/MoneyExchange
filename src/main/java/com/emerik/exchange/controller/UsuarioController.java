package com.emerik.exchange.controller;

import com.emerik.exchange.model.Usuario;
import com.emerik.exchange.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class UsuarioController {

    private final UsuarioService service;

    UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/registro")
    public Mono<ResponseEntity> registro(@RequestBody Usuario usuario) {
        return service.registroUsuuario(usuario)
                .map(user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.badRequest().body(null));
    }

    @GetMapping("/login")
    public Mono<ResponseEntity> login(@RequestBody Usuario usuario) {
        return service.login(usuario)
                .map(token -> ResponseEntity.status(HttpStatus.OK).body(token))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
