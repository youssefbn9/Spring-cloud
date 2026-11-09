package org.example.instrument;

import org.example.instrument.entities.Instrument;
import org.example.instrument.repos.InstrumentRepository;
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
    CommandLineRunner commandLineRunner(InstrumentRepository instrumentRepository) {
        return args -> {
            if (instrumentRepository.count() == 0) {
                instrumentRepository.save(Instrument.builder()
                        .name("Oud")
                        .code("OD")
                        .build());
                instrumentRepository.save(Instrument.builder()
                        .name("Derbouka")
                        .code("DB")
                        .build());
                instrumentRepository.save(Instrument.builder()
                        .name("Kamanja")
                        .code("KM")
                        .build());
                instrumentRepository.save(Instrument.builder()
                        .name("Nay")
                        .code("NY")
                        .build());
            }
        };
    }
}
