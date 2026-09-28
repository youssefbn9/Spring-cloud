package org.example.song.service;

import org.example.song.dto.APIResponseDto;

public interface songService {
    APIResponseDto getSongById(Long id);
}
