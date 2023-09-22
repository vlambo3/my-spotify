package com.example.playlistservice.service;

import com.example.playlistservice.model.Artist;
import com.example.playlistservice.model.Song;

import java.util.List;

public interface IServicePlaylist {

    List<Artist> getAllArtists();

    Artist createArtist4Feign(Artist artist);

    Artist createArtist4Playlist(Artist artist);

    List<Song> getAllSongs();

    Song createSong4Feign(Song song);

    Song createSong4Playlist(Song song);
    List<Object> getListByGenreFromPlaylist(String genre);

}
