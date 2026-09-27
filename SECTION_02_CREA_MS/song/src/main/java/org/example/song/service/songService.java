package org.example.song.service;

import org.example.song.dto.songDto;

public interface songService {
    songDto getSongById(Long id);
}
