package com.example.artistsservice.service.impl;

import com.example.artistsservice.model.Artist;
import com.example.artistsservice.queue.ArtistSender;
import com.example.artistsservice.repository.ArtistRepository;
import com.example.artistsservice.service.IArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistService implements IArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistSender artistSender;

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public List<Artist> findByGenre (String genre) {
        return artistRepository.findAllByGenre(genre);
    }

    @Override
    public Artist create (Artist artist) {
        artistSender.send(artist);
        return artistRepository.save(artist);
    }

}
