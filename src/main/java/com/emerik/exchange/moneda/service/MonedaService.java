package com.emerik.exchange.moneda.service;

import com.emerik.exchange.moneda.model.MonedaCambio;
import com.emerik.exchange.moneda.repositorio.MonedaRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MonedaService {

    private final MonedaRepo monedaRepo;

    public MonedaService(MonedaRepo monedaRepo) {
        this.monedaRepo = monedaRepo;
    }

    public Flux<MonedaCambio> getAllMonedas() {
        return monedaRepo.findAll();
    }

    public Mono<MonedaCambio> getMonedaByCodigo(String codigo) {
        return monedaRepo.findByCodigo(codigo.toUpperCase());
    }

    public Mono<MonedaCambio> saveMoneda(MonedaCambio moneda) {
        moneda.setCodigo(moneda.getCodigo().toUpperCase());
        return monedaRepo.save(moneda);
    }



}
