package org.example.song.restControllers;

import lombok.AllArgsConstructor;
import org.example.song.entities.song;
import org.example.song.repos.songRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Atelier 01 — Création simple du microservice song.
 * Pas encore de communication avec instrument-microservice.
 */
@RestController
@RequestMapping("/api/songs")
@AllArgsConstructor
public class songController {

    private final songRepository songRepository;

    @GetMapping
    public ResponseEntity<List<song>> getAllSongs() {
        return new ResponseEntity<>(songRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<song> getSongById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songRepository.findById(id).orElseThrow(), HttpStatus.OK);
    }
}
