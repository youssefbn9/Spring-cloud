package org.example.song.service;

import org.example.song.dto.InstrumentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INSTRUMENT")
public interface APIClient {

    @GetMapping("/api/instruments/{code}")
    InstrumentDto getInstrumentByCode(@PathVariable("code") String code);
}
