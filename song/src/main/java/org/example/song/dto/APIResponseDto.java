package org.example.song.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponseDto {
    private SongDto songDto;
    private InstrumentDto instrumentDto;
}
