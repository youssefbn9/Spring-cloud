package org.example.instrument.service;

import lombok.AllArgsConstructor;
import org.example.instrument.dto.InstrumentDto;
import org.example.instrument.entities.Instrument;
import org.example.instrument.repos.InstrumentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Override
    public InstrumentDto getInstrumentByCode(String code) {
        Instrument inst = instrumentRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Instrument not found with code: " + code));
        return new InstrumentDto(
                inst.getId(),
                inst.getName(),
                inst.getCode()
        );
    }

    @Override
    public InstrumentDto getInstrumentById(Long id) {
        Instrument inst = instrumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrument not found with id: " + id));
        return new InstrumentDto(
                inst.getId(),
                inst.getName(),
                inst.getCode()
        );
    }
}
