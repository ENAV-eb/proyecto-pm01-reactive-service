package com.eb.na.data_modulo_generator.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class DataModelo {

    private static final MathContext MATH_CONTEXT = new MathContext(2);

    private BigDecimal temperatura;
    private BigDecimal humedad;
    private BigDecimal luminosidad;
    private BigDecimal ph_suelo;
    private BigDecimal crop;
    private Instant tiempo;


    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public BigDecimal getHumedad() {
        return humedad;
    }

    public void setHumedad(BigDecimal humedad) {
        this.humedad = humedad;
    }

    public BigDecimal getLuminosidad() {
        return luminosidad;
    }

    public void setLuminosidad(BigDecimal luminosidad) {
        this.luminosidad = luminosidad;
    }

    public BigDecimal getPh_suelo() {
        return ph_suelo;
    }

    public void setPh_suelo(BigDecimal ph_suelo) {
        this.ph_suelo = ph_suelo;
    }

    public BigDecimal getCrop() {
        return crop;
    }

    public void setCrop(BigDecimal crop) {
        this.crop = crop;
    }

    public Instant getTiempo() {
        return tiempo;
    }

    public void setTiempo(Instant tiempo) {
        this.tiempo = tiempo;
    }


    public DataModelo(double temperatura, double humedad, double luminosidad, 
    double ph_suelo, double crop) {
        this.temperatura = new BigDecimal(temperatura, MATH_CONTEXT);
        this.humedad = new BigDecimal(humedad, MATH_CONTEXT);
        this.luminosidad = new BigDecimal(luminosidad, MATH_CONTEXT);
        this.ph_suelo = new BigDecimal(ph_suelo, MATH_CONTEXT);
        this.crop = new BigDecimal(crop, MATH_CONTEXT);
    }

    public DataModelo() {
    }

    public DataModelo(BigDecimal temperatura, BigDecimal humedad, BigDecimal luminosidad, BigDecimal ph_suelo,
            BigDecimal crop, Instant tiempo) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.luminosidad = luminosidad;
        this.ph_suelo = ph_suelo;
        this.crop = crop;
        this.tiempo = tiempo;
    }

	

    
    
}
