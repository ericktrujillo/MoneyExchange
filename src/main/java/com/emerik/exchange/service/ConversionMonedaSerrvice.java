package com.emerik.exchange.service;

import com.emerik.exchange.model.AuditoriaCambio;
import com.emerik.exchange.repository.AuditoriaRepo;
import com.emerik.exchange.repository.MonedaRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
public class ConversionMonedaSerrvice {

    private final MonedaRepo monedaRepo;
    private final AuditoriaRepo auditoriaRepo;

    ConversionMonedaSerrvice(MonedaRepo monedaRepo, AuditoriaRepo auditoriaRepo) {
        this.monedaRepo = monedaRepo;
        this.auditoriaRepo = auditoriaRepo;
    }

    //@Transactional
    public Mono<AuditoriaCambio> generarConversion(long idUsuario, String codigoBase, String codigoResult, double montoBase) {
        return monedaRepo.findByCodigo(codigoBase.toUpperCase())
                .flatMap(mon -> monedaRepo.findByCodigo(codigoResult.toUpperCase())
                        .map(monObj -> {
                            AuditoriaCambio aud = new AuditoriaCambio();
                            aud.setIdUsuario(idUsuario);
                            aud.setMonedaBase(mon.getMoneda());
                            aud.setTasaMonedaBase(mon.getTasa_conversion());
                            aud.setMontoBase(montoBase);
                            aud.setMonedaObjetivo(monObj.getMoneda());
                            aud.setTasaMonedaObjetivo(monObj.getTasa_conversion());
                            aud.setFechaConversion(LocalDateTime.now());
                            aud.setMontoResultado(conversorValorMoneda(aud));
                            return aud;
                        }).flatMap(auditoriaRepo::save)
                );
    }

    private double conversorValorMoneda(AuditoriaCambio aud) {
        BigDecimal resultado = BigDecimal.valueOf((aud.getMontoBase()/aud.getTasaMonedaBase())*aud.getTasaMonedaObjetivo());
        return resultado.setScale(2, RoundingMode.CEILING).doubleValue();
    }

    public Flux<AuditoriaCambio> getAuditoriaList(){
        return auditoriaRepo.findAll();
    }

}
