package com.emerik.exchange.repository;

import com.emerik.exchange.model.MonedaCambio;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface MonedaRepo extends R2dbcRepository<MonedaCambio,Long> {

    Mono<MonedaCambio> findByCodigo(String codigo);
}
