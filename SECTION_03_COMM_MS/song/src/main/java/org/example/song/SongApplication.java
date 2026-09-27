package org.example.song;

import org.example.song.entities.song;
import org.example.song.repos.songRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Point d'entrée du microservice song.
 *
 * @EnableFeignClients : active le scan des interfaces annotées @FeignClient
 *                       (nécessaire pour l'Atelier 02 - Partie B).
 */
@SpringBootApplication
@EnableFeignClients
public class SongApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongApplication.class, args);
    }

    /**
     * Bean WebClient — déclaré ici pour l'Atelier 02 Partie A (communication manuelle).
     * Conservé même après passage à OpenFeign, il peut servir pour d'autres usages.
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    /**
     * Données de test insérées au démarrage.
     * Les codes d'instrument (ex: "PN") doivent correspondre
     * à ceux insérés dans instrument-microservice.
     */
    @Bean
    CommandLineRunner commandLineRunner(songRepository songRepository) {
        return args -> {
            songRepository.save(song.builder()
                    .title("Allah Allah Ya Baba")
                    .artist("Hedi Jouini")
                    .instrumentCode("OD")   // → Oud dans instrument-microservice
                    .build());
            songRepository.save(song.builder()
                    .title("Ya Zin Walli Bidek")
                    .artist("Saliha")
                    .instrumentCode("KM")   // → Kamanja dans instrument-microservice
                    .build());
            songRepository.save(song.builder()
                    .title("Mabrouk Alik")
                    .artist("Oulaya")
                    .instrumentCode("DB")   // → Derbouka dans instrument-microservice
                    .build());
            songRepository.save(song.builder()
                    .title("Foug El-Nakhal")
                    .artist("Hedi Jouini")
                    .instrumentCode("NY")   // → Nay dans instrument-microservice
                    .build());
        };
    }
}
