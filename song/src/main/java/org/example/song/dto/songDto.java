package org.example.song.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDto {
    private Long id;
    private String title;
    private String artist;
    private String instrumentCode;
    private String instrumentName;
}
