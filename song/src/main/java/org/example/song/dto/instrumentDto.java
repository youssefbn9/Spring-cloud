package org.example.song.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copie locale de l'instrumentDto du microservice instrument.
 * Utilisée pour désérialiser la réponse JSON reçue depuis instrument-microservice
 * (via WebClient ou OpenFeign).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class instrumentDto {
    private Long id;
    private String instrumentName;
    private String instrumentCode;
}
