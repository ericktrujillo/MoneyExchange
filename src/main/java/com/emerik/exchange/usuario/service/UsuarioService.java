package com.emerik.exchange.usuario.service;

import com.emerik.exchange.usuario.dto.TokenDto;
import com.emerik.exchange.usuario.model.Usuario;
import com.emerik.exchange.usuario.repositorio.UsuarioRepo;
import com.emerik.exchange.security.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {

    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    UsuarioService(UsuarioRepo usuarioRepo,
                   PasswordEncoder encoder,
                   JwtProvider provider) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = encoder;
        this.jwtProvider = provider;
    }

    public Mono<Usuario> registroUsuuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepo.existsByUsername(usuario.getUsername())
                .flatMap(exists -> exists ?
                        Mono.error(new Throwable("Usuario ya existe!"))
                        : usuarioRepo.save(usuario));


    }

    public Mono<TokenDto> login(Usuario usuario) {
        return usuarioRepo.findByUsername(usuario.getUsername())
                .filter(user -> passwordEncoder.matches(usuario.getPassword(),user.getPassword()))
                .map(user -> new TokenDto(jwtProvider.generateToken(user)))
                .switchIfEmpty(Mono.error(new Throwable("Credenciales incorrectos")));
    }
}
