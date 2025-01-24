package com.emerik.exchange.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class MonedaCambio {
    @Id
    private long id;
    private String codigo;
    private String moneda;
    private double tasa_conversion;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getTasa_conversion() {
        return tasa_conversion;
    }

    public void setTasa_conversion(double tasa_conversion) {
        this.tasa_conversion = tasa_conversion;
    }
}
