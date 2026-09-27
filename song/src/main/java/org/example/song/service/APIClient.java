package org.example.song.service;

import org.example.song.dto.instrumentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Client OpenFeign déclaratif pour instrument-microservice.
 *
 * Au lieu d'écrire manuellement un appel HTTP, on déclare simplement
 * une interface avec les signatures de méthodes correspondant aux endpoints
 * de instrument-microservice. Spring génère l'implémentation automatiquement.
 *
 * url  = adresse de instrument-microservice (port 8080)
 * value = nom logique du client (utilisé par Eureka dans les ateliers suivants)
 */
@FeignClient(url = "http://localhost:8082", value = "INSTRUMENT")
public interface APIClient {

    @GetMapping("api/instruments/{instrument-code}")
    instrumentDto getInstrumentByCode(@PathVariable("instrument-code") String instrumentCode);
}
