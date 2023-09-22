package com.example.songservice.service.impl;

import com.example.songservice.domain.model.Song;
import com.example.songservice.queue.SongSender;
import com.example.songservice.repository.SongRepository;
import com.example.songservice.service.ISongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SongService implements ISongService {

    private final SongRepository repository;
    private final SongSender songSender;

    @Override
    public List<Song> findAll() { return  repository.findAll(); }

    @Override
    public List<Song> findByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    @Override
    public Song save(Song song) {
        songSender.send(song);
        return repository.save(song);
    }
}
