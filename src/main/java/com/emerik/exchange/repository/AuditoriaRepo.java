package com.emerik.exchange.repository;

import com.emerik.exchange.model.AuditoriaCambio;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepo extends R2dbcRepository<AuditoriaCambio,Long> {
}
