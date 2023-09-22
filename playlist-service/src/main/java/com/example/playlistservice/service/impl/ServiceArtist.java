package com.example.playlistservice.service.impl;

import com.example.playlistservice.client.IArtistClient;
import com.example.playlistservice.client.ISongClient;
import com.example.playlistservice.model.Artist;
import com.example.playlistservice.model.Song;
import com.example.playlistservice.repository.ArtistRepository;
import com.example.playlistservice.repository.SongRepository;
import com.example.playlistservice.service.IServicePlaylist;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceArtist implements IServicePlaylist {

    private final ISongClient iSongClient;
    private final IArtistClient  iArtistClient;
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    @Override
    public List<Artist> getAllArtists() {
        return iArtistClient.getAll();
    }

    @Override
    public Artist createArtist4Feign(Artist artist) {
        return iArtistClient.create(artist);
    }

    @Override
    public Artist createArtist4Playlist(Artist artist) {
        return artistRepository.save(artist);
    }

    @CircuitBreaker(name = "song", fallbackMethod = "findAllSongFallback")
    @Retry(name = "song")
    @Override
    public List<Song> getAllSongs() {
        return iSongClient.getAll();
    }

    private List<Song> findAllSongFallback (CallNotPermittedException exception) {
        return songRepository.findAll();
    }

    @Override
    public Song createSong4Feign(Song song) {
        return iSongClient.save(song);
    }

    @Override
    public Song createSong4Playlist(Song song) {
        return songRepository.save(song);
    }

//    @Override
//    public Playlist getListByGenre(String genre) {
//        return Playlist.builder()
//                .genre(genre)
//                .music(iMusicClient.getMusicByGenre(genre))
//                .artists(iArtistClient.getByGenre(genre))
//                .build();
//    }

    @Override
    public List<Object> getListByGenreFromPlaylist(String genre) {
        List<Object> allByGenre = new ArrayList<>();

        //Filtramos artistas por género
        List<Artist> artistList = artistRepository.findArtistByGenre(genre);
        allByGenre.add(artistList);

        //Filtramos música por género
        List<Song> songList = songRepository.findSongByGenre(genre);
        allByGenre.add(songList);

        return allByGenre;
    }


}
