package org.example.song.service;

import lombok.AllArgsConstructor;
import org.example.song.dto.APIResponseDto;
import org.example.song.dto.InstrumentDto;
import org.example.song.dto.SongDto;
import org.example.song.entities.Song;
import org.example.song.repos.SongRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final APIClient apiClient;

    @Override
    public APIResponseDto getSongById(Long id) {
        Song s = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found with id: " + id));

        InstrumentDto instrumentDto = null;
        try {
            instrumentDto = apiClient.getInstrumentByCode(s.getInstrumentCode());
        } catch (Exception e) {
            instrumentDto = InstrumentDto.builder()
                    .name("Unknown")
                    .code(s.getInstrumentCode())
                    .build();
        }

        SongDto songDto = SongDto.builder()
                .id(s.getId())
                .title(s.getTitle())
                .artist(s.getArtist())
                .instrumentCode(s.getInstrumentCode())
                .instrumentName(instrumentDto != null ? instrumentDto.getName() : null)
                .build();

        return APIResponseDto.builder()
                .songDto(songDto)
                .instrumentDto(instrumentDto)
                .build();
    }
}
