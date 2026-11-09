package org.example.song;

import org.example.song.entities.Song;
import org.example.song.repos.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class SongApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SongRepository songRepository) {
        return args -> {
            if (songRepository.count() == 0) {
                songRepository.save(Song.builder()
                        .title("Samai Bayati")
                        .artist("Traditionnel")
                        .instrumentCode("OD")
                        .build());
                songRepository.save(Song.builder()
                        .title("Alf Leila wa Leila")
                        .artist("Oum Kalthoum")
                        .instrumentCode("KM")
                        .build());
                songRepository.save(Song.builder()
                        .title("Rythme Oriental")
                        .artist("Soliste")
                        .instrumentCode("DB")
                        .build());
            }
        };
    }
}
