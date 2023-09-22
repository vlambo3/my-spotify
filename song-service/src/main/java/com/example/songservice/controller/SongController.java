package com.example.songservice.controller;

import com.example.songservice.domain.model.Song;
import com.example.songservice.service.ISongService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
@AllArgsConstructor
public class SongController {

    private final ISongService service;

    //	consulto todas las canciones
    @GetMapping("/all")
    ResponseEntity<List<Song>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    //	consulto las canciones filtrando por género
    @GetMapping("/{genre}")
    ResponseEntity<List<Song>> getSongByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.findByGenre(genre));
    }

    //	guardo una canción
    @PostMapping("/save")
    ResponseEntity<Song> saveSong(@RequestBody Song song) {
        return ResponseEntity.ok().body(service.save(song));
    }
}
