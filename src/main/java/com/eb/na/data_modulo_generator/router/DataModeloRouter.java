package com.eb.na.data_modulo_generator.router;

import com.eb.na.data_modulo_generator.handler.DataModeloHandler;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import java.util.logging.Logger;

@Configuration
public class DataModeloRouter {

  
    @Bean 
    public RouterFunction<ServerResponse> route(DataModeloHandler dataModeloHandler) {
        return RouterFunctions
        .route(GET("/data").and(accept(APPLICATION_STREAM_JSON)),
         dataModeloHandler::streamDataModelo)
        .andRoute(GET("/data02").and(accept(APPLICATION_STREAM_JSON)),
         dataModeloHandler::streamDataModelo02);
    }
    
}
