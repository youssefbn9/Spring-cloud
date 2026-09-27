package org.example.song.service;

import org.example.song.dto.songDto;
import org.example.song.entities.song;
import org.example.song.repos.songRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Atelier 01 — Service song simple.
 * Retourne uniquement les données de la chanson (sans appel à instrument-microservice).
 */
@Service
public class songServiceImpl implements songService {

    @Autowired
    songRepository songRepository;

    @Override
    public songDto getSongById(Long id) {
        song s = songRepository.findById(id).orElseThrow();
        return new songDto(s.getId(), s.getTitle(), s.getArtist(), s.getInstrumentCode());
    }
}
