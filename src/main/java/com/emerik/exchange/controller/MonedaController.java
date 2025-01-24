package com.emerik.exchange.controller;

import com.emerik.exchange.model.MonedaCambio;
import com.emerik.exchange.repository.MonedaRepo;
import com.emerik.exchange.service.MonedaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/moneda")
public class MonedaController {

    private final MonedaService service;

    public MonedaController(MonedaService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    Mono<ResponseEntity> getMonedas() {
        return service.getAllMonedas()
                .reduce(new ArrayList<MonedaCambio>(),
                        (result,moneda)->{
                            result.add(moneda);
                            return result;
                        })
                .map(res -> ResponseEntity.status(HttpStatus.OK).body(res))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping(path = "/{codigo}")
    Mono<ResponseEntity> getMonedaByCodigo(@PathVariable("codigo") String codigo) {
        return service.getMonedaByCodigo(codigo)
                .map(res -> ResponseEntity.status(HttpStatus.OK).body(res))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

    }

    @PostMapping(path = "/admin/create")
    Mono<ResponseEntity> saveMoneda(@RequestBody MonedaCambio moneda) {

        return service.saveMoneda(moneda)
                .map(res-> ResponseEntity.status(HttpStatus.OK).body(res))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }
}
