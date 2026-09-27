package org.example.song.restControllers;

import lombok.AllArgsConstructor;
import org.example.song.dto.APIResponseDto;
import org.example.song.service.songService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs")
@AllArgsConstructor
public class songController {

    private final songService songService;

    /**
     * GET /api/songs/{id}
     * Retourne la chanson + l'instrument associé (via instrument-microservice).
     */
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getSongById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.getSongById(id), HttpStatus.OK);
    }
}
