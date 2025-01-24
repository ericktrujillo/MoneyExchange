package com.emerik.exchange.conversion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class AuditoriaCambio {

    @Id
    private long id;
    private long idUsuario;
    private String monedaBase;
    private double tasaMonedaBase;
    private double montoBase;
    private String monedaObjetivo;
    private double tasaMonedaObjetivo;
    private double montoResultado;
    private LocalDateTime fechaConversion;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public double getTasaMonedaBase() {
        return tasaMonedaBase;
    }

    public void setTasaMonedaBase(double tasaMonedaBase) {
        this.tasaMonedaBase = tasaMonedaBase;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public double getTasaMonedaObjetivo() {
        return tasaMonedaObjetivo;
    }

    public void setTasaMonedaObjetivo(double tasaMonedaObjetivo) {
        this.tasaMonedaObjetivo = tasaMonedaObjetivo;
    }

    public double getMontoResultado() {
        return montoResultado;
    }

    public void setMontoResultado(double montoResultado) {
        this.montoResultado = montoResultado;
    }

    public LocalDateTime getFechaConversion() {
        return fechaConversion;
    }

    public void setFechaConversion(LocalDateTime fechaCambio) {
        this.fechaConversion = fechaCambio;
    }
}
