package com.example.playlistservice.queue;

import com.example.playlistservice.model.Artist;
import com.example.playlistservice.model.Song;
import com.example.playlistservice.service.IServicePlaylist;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaylistReceive {
    private final IServicePlaylist iServicePlaylist;

//  con este método ms-playlist lee el mensaje de la cola y lo persiste en su DB
    @RabbitListener(queues = {"${queue.artist.name}"})
    public void receiveArtist(@Payload Artist artist) {
        iServicePlaylist.createArtist4Playlist(artist);
    }
//  con este método ms-playlist lee el mensaje de la cola y lo persiste en su DB
    @RabbitListener(queues = {"${queue.song.name}"})
    public void receiveSong(@Payload Song song) {
        iServicePlaylist.createSong4Playlist(song);
    }
}
