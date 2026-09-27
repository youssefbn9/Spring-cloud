package org.example.instrument.service;

import lombok.AllArgsConstructor;
import org.example.instrument.dto.instrumentDto;
import org.example.instrument.entities.instrument;
import org.example.instrument.repos.instrumentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class instrumentServiceImpl implements instrumentService {

    private final instrumentRepository instrumentRepository;

    @Override
    public instrumentDto getInstrumentByCode(String code) {
        instrument inst = instrumentRepository.findByInstrumentCode(code);
        if (inst == null) {
            throw new RuntimeException("Instrument not found with code: " + code);
        }
        return new instrumentDto(
                inst.getId(),
                inst.getInstrumentName(),
                inst.getInstrumentCode()
        );
    }

    @Override
    public instrumentDto getInstrumentById(Long id) {
        instrument inst = instrumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrument not found with id: " + id));
        return new instrumentDto(
                inst.getId(),
                inst.getInstrumentName(),
                inst.getInstrumentCode()
        );
    }
}
