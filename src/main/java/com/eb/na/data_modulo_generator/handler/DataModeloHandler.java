package com.eb.na.data_modulo_generator.handler;

import com.eb.na.data_modulo_generator.generator.DataModelGenerator;
import com.eb.na.data_modulo_generator.model.DataModelo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class DataModeloHandler {

    private final DataModelGenerator dataModelGenerator;

    public DataModeloHandler(DataModelGenerator dataModelGenerator) {
        this.dataModelGenerator = dataModelGenerator;
    }

    public Mono<ServerResponse> streamDataModelo(ServerRequest request) {
        return ok()
                    .contentType(APPLICATION_STREAM_JSON)
                    .body(this.dataModelGenerator.fetchDataStream(),DataModelo.class);
    }

    public Mono<ServerResponse> streamDataModelo02(ServerRequest request) {
        return ok()
                    .contentType(APPLICATION_STREAM_JSON)
                    .body(this.dataModelGenerator.fetchDataStream02(),DataModelo.class);
    }
    
}
