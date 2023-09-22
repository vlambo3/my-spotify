package com.example.artistsservice.controllador;

import com.example.artistsservice.model.Artist;
import com.example.artistsservice.service.IArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
@AllArgsConstructor
public class ArtistController {
    private final IArtistService artistService;

//  consulta todos los artistas
    @GetMapping("/all")
    public ResponseEntity<List<Artist>> getAll() {
        return ResponseEntity.ok(artistService.getAll());
    }

//  filtra a los artístas por género musical
    @GetMapping("/{genre}")
    public ResponseEntity<List<Artist>> getByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(artistService.findByGenre(genre));
    }
//  crea un artista
    @PostMapping("/create")
    public ResponseEntity<Artist> create (@RequestBody Artist artist) {
        return ResponseEntity.ok().body(artistService.create(artist));
    }
}
