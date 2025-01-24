package com.emerik.exchange.conversion.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ConversionDto {

    private long idUsuario;

    @NotBlank(message = "Ingrese codigo de moneda base(PEN,USD,EUR)")
    private String codigoBase;

    @NotBlank(message = "Ingrese codigo de moneda base(PEN,USD,EUR)")
    private String codigoObjetivo;

    @Min(value = 0 ,message = "Ingrese un monto mayor a 0")
    private double montoBase;

    private double montoResultado;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigoBase() {
        return codigoBase;
    }

    public void setCodigoBase(String codigoBase) {
        this.codigoBase = codigoBase;
    }

    public String getCodigoObjetivo() {
        return codigoObjetivo;
    }

    public void setCodigoObjetivo(String codigoObjetivo) {
        this.codigoObjetivo = codigoObjetivo;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    public double getMontoResultado() {
        return montoResultado;
    }

    public void setMontoResultado(double montoResultado) {
        this.montoResultado = montoResultado;
    }
}
