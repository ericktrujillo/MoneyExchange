package com.emerik.exchange.usuario.repositorio;

import com.emerik.exchange.usuario.model.Usuario;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepo extends R2dbcRepository<Usuario,Long> {

    Mono<Usuario> findByUsername(String username);

    Mono<Boolean> existsByUsername(String username);
}
