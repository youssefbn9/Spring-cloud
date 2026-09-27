package org.example.instrument.service;

import org.example.instrument.dto.instrumentDto;

public interface instrumentService {
    instrumentDto getInstrumentByCode(String code);
    instrumentDto getInstrumentById(Long id);
}
