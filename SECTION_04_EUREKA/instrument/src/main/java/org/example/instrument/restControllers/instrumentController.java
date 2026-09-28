package org.example.instrument.restControllers;

import lombok.AllArgsConstructor;
import org.example.instrument.dto.instrumentDto;
import org.example.instrument.service.instrumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instruments")
@AllArgsConstructor
public class instrumentController {

    private final instrumentService instrumentService;

    // Recherche par CODE (ex: PN, GT, BT) — utilisé par song-microservice via OpenFeign
    @GetMapping("{code}")
    public ResponseEntity<instrumentDto> getInstrumentByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(instrumentService.getInstrumentByCode(code), HttpStatus.OK);
    }

    // Recherche par ID numérique (ex: 1, 2, 3) — pour tester comme le professeur
    @GetMapping("/id/{id}")
    public ResponseEntity<instrumentDto> getInstrumentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(instrumentService.getInstrumentById(id), HttpStatus.OK);
    }
}
