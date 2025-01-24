package com.emerik.exchange.controller;

import com.emerik.exchange.dto.ConversionDto;
import com.emerik.exchange.model.AuditoriaCambio;
import com.emerik.exchange.service.ConversionMonedaSerrvice;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/v1/convert")
public class ConversionController {

    private final ConversionMonedaSerrvice service;

    public ConversionController(ConversionMonedaSerrvice service) {
        this.service = service;
    }

    @PostMapping("/")
    public Mono<ResponseEntity> conversion(@Valid @RequestBody ConversionDto dto) {
        return service.generarConversion(dto.getIdUsuario(), dto.getCodigoBase(), dto.getCodigoObjetivo(), dto.getMontoBase())
                .map(res -> {
                    dto.setMontoResultado(res.getMontoResultado());
                    return ResponseEntity.status(HttpStatus.OK).body(dto);
                }).cast(ResponseEntity.class)
                .subscribeOn(Schedulers.boundedElastic())
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @GetMapping("/")
    public Flux<AuditoriaCambio> getAuditoriaList(){
        return service.getAuditoriaList();
    }
}
