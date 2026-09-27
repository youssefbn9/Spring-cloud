package org.example.song.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class songDto {
    private Long id;
    private String title;
    private String artist;
    private String instrumentCode;
    // Enrichi par OpenFeign (Atelier 02 - Partie B) : nom complet de l'instrument
    private String instrumentName;
}
