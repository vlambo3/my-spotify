package com.example.songservice.service;

import com.example.songservice.domain.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    List<Song> findByGenre(String genre);
    Song save(Song song);
}
