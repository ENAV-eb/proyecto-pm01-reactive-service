package com.eb.na.data_modulo_generator.model;

import java.math.BigDecimal;
import java.time.Instant;

public class DataModeloFirebase {

    private String temperatura;
    private String humedad;
    private String luminosidad;
    private String ph_suelo;
    private String crop;
    private String tiempo;

    public DataModeloFirebase(DataModelo dModelo) {
        this.temperatura = dModelo.getTemperatura().toString();
        this.humedad = dModelo.getHumedad().toString();
        this.luminosidad = dModelo.getLuminosidad().toString();
        this.ph_suelo = dModelo.getPh_suelo().toString();
        this.crop = dModelo.getCrop().toString();
        this.tiempo = dModelo.getTiempo().toString();
    }

    public DataModeloFirebase() {
    }

    public DataModeloFirebase(String temperatura, String humedad, String luminosidad, String ph_suelo, String crop,
            String tiempo) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.luminosidad = luminosidad;
        this.ph_suelo = ph_suelo;
        this.crop = crop;
        this.tiempo = tiempo;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getLuminosidad() {
        return luminosidad;
    }

    public void setLuminosidad(String luminosidad) {
        this.luminosidad = luminosidad;
    }

    public String getPh_suelo() {
        return ph_suelo;
    }

    public void setPh_suelo(String ph_suelo) {
        this.ph_suelo = ph_suelo;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "DataModeloFirebase [crop=" + crop + ", humedad=" + humedad + ", luminosidad=" + luminosidad
                + ", ph_suelo=" + ph_suelo + ", temperatura=" + temperatura + ", tiempo=" + tiempo + "]";
    }

    

    
    
}
