package com.example.artistsservice.service;

import com.example.artistsservice.model.Artist;

import java.util.List;

public interface IArtistService {
    List<Artist> getAll();
    List<Artist> findByGenre (String genre);
    Artist create (Artist artist);

}
