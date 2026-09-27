package org.example.song.service;

import org.example.song.dto.APIResponseDto;
import org.example.song.dto.instrumentDto;
import org.example.song.dto.songDto;
import org.example.song.entities.song;
import org.example.song.repos.songRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class songServiceImpl implements songService {

    @Autowired
    songRepository songRepository;

    @Autowired
    private APIClient apiClient;

    @Override
    public APIResponseDto getSongById(Long id) {
        song s = songRepository.findById(id).get();

        instrumentDto instrumentDto = apiClient.getInstrumentByCode(s.getInstrumentCode());

        songDto songDto = new songDto(
                s.getId(),
                s.getTitle(),
                s.getArtist(),
                s.getInstrumentCode(),
                instrumentDto.getInstrumentName()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setSongDto(songDto);
        apiResponseDto.setInstrumentDto(instrumentDto);

        return apiResponseDto;
    }
}
