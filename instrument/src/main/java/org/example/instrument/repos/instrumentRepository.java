package org.example.instrument.repos;

import org.example.instrument.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    Optional<Instrument> findByCode(String code);

    default Instrument findByInstrumentCode(String code) {
        return findByCode(code).orElse(null);
    }
}
