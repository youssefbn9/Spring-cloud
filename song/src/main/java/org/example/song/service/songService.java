package org.example.song.service;

import org.example.song.dto.APIResponseDto;

public interface SongService {
    APIResponseDto getSongById(Long id);
}
