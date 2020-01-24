package com.enigma.service.impl;

import com.enigma.entity.Artist;
import com.enigma.entity.Song;

import java.util.List;

public interface SongServices {
    Song save(Song song);
    List<Song> getAll ();
    Song getSongId(String id);
    void deleteSong(String id);
    List<Song> GetAllByIdSArtist(String Keyword);
    List<Song> getSongfromArtist(String id);

}
