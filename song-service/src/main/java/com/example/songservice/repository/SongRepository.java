package com.example.songservice.repository;

import com.example.songservice.domain.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("SELECT s FROM Songs s WHERE s.genre = ?1")
    List<Song> findByGenre(String genre);
}
