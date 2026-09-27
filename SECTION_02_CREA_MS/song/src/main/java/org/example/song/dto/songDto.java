package org.example.song.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Atelier 01 — DTO simple de la chanson sans enrichissement.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class songDto {
    private Long id;
    private String title;
    private String artist;
    private String instrumentCode;
}
