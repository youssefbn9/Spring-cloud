package org.example.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    /**
     * Configuration des routes par RouteLocatorBuilder (comme demandé à l'étape 3 de l'atelier).
     * Mappe /api/songs/** vers le microservice SONG et /api/instruments/** vers INSTRUMENT.
     * Mappe également /api/departments/** et /api/teachers/** pour compatibilité avec l'exemple du professeur.
     */
    @Bean
    public RouteLocator MyRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("song-service-route", p -> p
                        .path("/api/songs/**")
                        .uri("lb://SONG"))
                .route("instrument-service-route", p -> p
                        .path("/api/instruments/**")
                        .uri("lb://INSTRUMENT"))
                .route("department-route", p -> p
                        .path("/api/departments/**")
                        .uri("lb://DEPARTMENT"))
                .route("teacher-route", p -> p
                        .path("/api/teachers/**")
                        .uri("lb://TEACHER"))
                .build();
    }
}
