package org.example.instrument.service;

import org.example.instrument.dto.InstrumentDto;

public interface InstrumentService {
    InstrumentDto getInstrumentByCode(String code);
    InstrumentDto getInstrumentById(Long id);
}
