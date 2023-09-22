package com.example.playlistservice.client;

import com.example.playlistservice.model.Artist;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "artist-service")
public interface IArtistClient {

    @GetMapping("/artist/all")
    List<Artist> getAll();

    @PostMapping("/artist/create")
    Artist create (@RequestBody Artist artist) ;
}
