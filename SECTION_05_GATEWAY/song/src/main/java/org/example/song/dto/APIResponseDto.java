package org.example.song.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de réponse globale retourné par GET /api/songs/{id}.
 * Agrège les données de song-microservice ET de instrument-microservice.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private songDto songDto;
    private instrumentDto instrumentDto;
}
