package com.eb.na.data_modulo_generator.generator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.eb.na.data_modulo_generator.model.DataModelo;
import com.eb.na.data_modulo_generator.model.DataModeloFirebase;
import com.google.firebase.database.FirebaseDatabase;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class DataModelGenerator {

    private final MathContext mathContext = new MathContext(2);

    private final Random random = new Random();
    
    private final List<DataModelo> data = new ArrayList<>();

    private final Flux<DataModelo> dataStream;

    private final Flux<DataModelo> dataStream02;

    //private String id;

    public DataModelGenerator() {
        initializeData();
        this.dataStream = getDataStream();
        this.dataStream02 = getDataStream02();

    }

    public Flux<DataModelo> fetchDataStream() {
        return dataStream;
    }

    public Flux<DataModelo> fetchDataStream02() {
        return dataStream02;
    }

    private void initializeData() {
        this.data.add(new DataModelo(21.07,74.35,423.00,5.50,45.75));
    }

    private Flux<DataModelo> getDataStream() {
        return Flux.interval(Duration.ofSeconds(10))
        .onBackpressureDrop()
        .map(this::generateData)
        .flatMapIterable(d -> d)
        .share();
    }

    private Flux<DataModelo> getDataStream02() {
        return Flux.interval(Duration.ofSeconds(10))
        .onBackpressureDrop()
        .map(this::generateData02)
        .flatMapIterable(d -> d)
        .share();
    }

    private List<DataModelo> generateData(long i) {
        Instant instant = Instant.now();
        return data.stream()
                .map(baseData -> {
                    BigDecimal temperatureChange = baseData.getTemperatura()
                    .multiply(new BigDecimal(0.05 * this.random.nextDouble()),this.mathContext);

                    BigDecimal humedadChange = baseData.getHumedad()
                    .multiply(new BigDecimal(0.05 * this.random.nextDouble()),this.mathContext);

                    BigDecimal luminosidadChange = baseData.getLuminosidad()
                    .multiply(new BigDecimal(0.05 * this.random.nextDouble()),this.mathContext);

                    BigDecimal ph_sueloChange = baseData.getPh_suelo()
                    .multiply(new BigDecimal(0.05 * this.random.nextDouble()),this.mathContext);

                    BigDecimal cropChange = baseData.getCrop()
                    .multiply(new BigDecimal(0.05 * this.random.nextDouble()),this.mathContext);

                    DataModelo dModelo = new DataModelo(baseData.getTemperatura().add(temperatureChange), 
                    baseData.getPh_suelo().add(humedadChange),
                    baseData.getLuminosidad().add(luminosidadChange),
                    baseData.getPh_suelo().add(ph_sueloChange),
                    baseData.getCrop().add(cropChange),
                    instant);

                    FirebaseDatabase.getInstance().getReference()
                    .child("modulos")
                    .child("4fc90a6e-35a6-4e3e-9c27-2a498a61327b")
                    .child("data").push()
                    .setValueAsync(new DataModeloFirebase(dModelo));

                    return dModelo;

                })
                .collect(Collectors.toList());
    }

    private List<DataModelo> generateData02(long i) {
        Instant instant = Instant.now();
        return data.stream()
                .map(baseData -> {
                    BigDecimal temperatureChange = baseData.getTemperatura()
                    .multiply(new BigDecimal(0.06 * this.random.nextDouble()),this.mathContext);

                    BigDecimal humedadChange = baseData.getHumedad()
                    .multiply(new BigDecimal(0.07 * this.random.nextDouble()),this.mathContext);

                    BigDecimal luminosidadChange = baseData.getLuminosidad()
                    .multiply(new BigDecimal(0.15 * this.random.nextDouble()),this.mathContext);

                    BigDecimal ph_sueloChange = baseData.getPh_suelo()
                    .multiply(new BigDecimal(0.03 * this.random.nextDouble()),this.mathContext);

                    BigDecimal cropChange = baseData.getCrop()
                    .multiply(new BigDecimal(0.02 * this.random.nextDouble()),this.mathContext);

                    DataModelo dModelo = new DataModelo(baseData.getTemperatura().add(temperatureChange), 
                    baseData.getPh_suelo().add(humedadChange),
                    baseData.getLuminosidad().add(luminosidadChange),
                    baseData.getPh_suelo().add(ph_sueloChange),
                    baseData.getCrop().add(cropChange),
                    instant);

                    FirebaseDatabase.getInstance().getReference()
                    .child("modulos")
                    .child("78cefee9-145d-4ebe-a19e-c25953231d5d")
                    .child("data").push()
                    .setValueAsync(new DataModeloFirebase(dModelo));

                    return dModelo;

                })
                .collect(Collectors.toList());
    }

    
    
}
