package org.example.instrument;

import org.example.instrument.entities.instrument;
import org.example.instrument.repos.instrumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InstrumentApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstrumentApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(instrumentRepository instrumentRepository) {
        return args -> {
            instrumentRepository.save(instrument.builder()
                    .instrumentName("Oud")
                    .instrumentCode("OD")
                    .build());
            instrumentRepository.save(instrument.builder()
                    .instrumentName("Derbouka")
                    .instrumentCode("DB")
                    .build());
            instrumentRepository.save(instrument.builder()
                    .instrumentName("Kamanja")
                    .instrumentCode("KM")
                    .build());
            instrumentRepository.save(instrument.builder()
                    .instrumentName("Nay")
                    .instrumentCode("NY")
                    .build());
        };
    }
}
