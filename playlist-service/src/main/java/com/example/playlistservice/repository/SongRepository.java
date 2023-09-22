package com.example.playlistservice.repository;


import com.example.playlistservice.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
    List<Song> findSongByGenre(String genre);
}
