package org.example.song.repos;

import org.example.song.entities.song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface songRepository extends JpaRepository<song, Long> {
}
