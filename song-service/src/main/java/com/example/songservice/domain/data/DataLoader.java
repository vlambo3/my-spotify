package com.example.songservice.domain.data;

import com.example.songservice.domain.model.Song;
import com.example.songservice.repository.SongRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private SongRepository repository;

    public DataLoader (SongRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run (ApplicationArguments args) throws Exception {
        repository.save(new Song(1L, "Djavan", "MPB", "what"));
        repository.save(new Song(2L, "Kevinho", "Funk", "what"));
        repository.save(new Song(3L, "Slipknot", "Rock", "what"));
        repository.save(new Song(4L, "Anitta", "Pop", "what"));
        repository.save(new Song(5L, "Djonga", "Hip Hop", "what"));
        repository.save(new Song(6L, "MD Chefe", "Trap", "what"));
        repository.save(new Song(7L, "Alok", "Eletronica", "what"));
        repository.save(new Song(8L, "Ivete Sangalo", "Axé", "what"));
    }
}
