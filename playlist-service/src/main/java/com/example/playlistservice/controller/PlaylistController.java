package com.example.playlistservice.controller;

import com.example.playlistservice.model.Artist;
import com.example.playlistservice.model.Song;
import com.example.playlistservice.service.IServicePlaylist;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/playlist")
public class PlaylistController {

    private final IServicePlaylist iServicePlaylist;


//  este endpoint consulta los artistas a la base de datos de ms-artist usando Feign
    @GetMapping("/artist/all")
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(iServicePlaylist.getAllArtists());
    }

//  este endpoint guarda artistas en la base de datos de ms-artist usando Feign
//  además cuando se persiste en ms-artist, se envía un mensaje en una cola para que también sea
//  persistido en la base de datos de ms-playlist
    @PostMapping("/artist/create")
    public ResponseEntity<Artist> createArtist4Feign(@RequestBody Artist artist) {
        return ResponseEntity.ok().body(iServicePlaylist.createArtist4Feign(artist));
    }

    //  este endpoint consulta las canciones a la base de datos de ms-song usando Feign
    @GetMapping("/song/all")
    public ResponseEntity<List<Song>> getAllSongs() {
        return ResponseEntity.ok(iServicePlaylist.getAllSongs());
    }


//  este endpoint guarda canciones en la base de datos de ms-song usando Feign
//  además cuando se persiste en ms-song, se envía un mensaje en una cola para que también sea
//  persistido en la base de datos de ms-playlist
    @PostMapping("/song/save")
    public ResponseEntity<Song> createSong4Feign(@RequestBody Song song) {
        return ResponseEntity.ok().body(iServicePlaylist.createSong4Feign(song));
    }

//  este endpoint consulta filtrando por género en la base de datos de ms-playlist
    @GetMapping("/{genre}")
    public ResponseEntity<List<Object>> getListByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(iServicePlaylist.getListByGenreFromPlaylist(genre));
    }

}
