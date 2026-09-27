package org.example.instrument.repos;

import org.example.instrument.entities.instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface instrumentRepository extends JpaRepository<instrument, Long> {

    instrument findByInstrumentCode(String code);
}
