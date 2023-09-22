package com.example.playlistservice.client;

import com.example.playlistservice.model.Song;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "song-service")
public interface ISongClient {

    @GetMapping("/song/all")
    List<Song> getAll();

    @PostMapping("/song/save")
    Song save(@RequestBody Song song);

}
