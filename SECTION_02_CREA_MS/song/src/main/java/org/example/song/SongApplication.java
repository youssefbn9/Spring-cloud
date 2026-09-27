package org.example.song;

import org.example.song.entities.song;
import org.example.song.repos.songRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Point d'entrée du microservice song — Atelier 01 (création simple).
 * Pas de communication inter-microservices à ce stade.
 */
@SpringBootApplication
public class SongApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(songRepository songRepository) {
        return args -> {
            songRepository.save(song.builder()
                    .title("Allah Allah Ya Baba")
                    .artist("Hedi Jouini")
                    .instrumentCode("OD")
                    .build());
            songRepository.save(song.builder()
                    .title("Ya Zin Walli Bidek")
                    .artist("Saliha")
                    .instrumentCode("KM")
                    .build());
            songRepository.save(song.builder()
                    .title("Mabrouk Alik")
                    .artist("Oulaya")
                    .instrumentCode("DB")
                    .build());
            songRepository.save(song.builder()
                    .title("Foug El-Nakhal")
                    .artist("Hedi Jouini")
                    .instrumentCode("NY")
                    .build());
        };
    }
}
