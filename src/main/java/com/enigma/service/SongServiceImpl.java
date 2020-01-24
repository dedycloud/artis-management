package com.enigma.service;

import com.enigma.entity.Artist;
import com.enigma.entity.Song;
import com.enigma.repositories.ArtistRepository;
import com.enigma.repositories.SongRepository;
import com.enigma.service.impl.ArtistServices;
import com.enigma.service.impl.SongServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongServices {
    @Autowired
    SongRepository songRepository;
@Autowired
    ArtistServices artistServices;
    @Override
    public Song save(Song song) {
        Artist artist = artistServices.getArtistId(song.getArtistIdTrasient());
        song.setArtistId(artist);
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongId(String id) {
        if (!songRepository.findById(id).isPresent()) {
            return new Song();
        }
        return songRepository.findById(id).get();
    }

    @Override
    public List<Song> GetAllByIdSArtist(String keyword) {
        return songRepository.findAllByArtistIdContains(keyword);
    }

    @Override
    public void deleteSong(String id) {
songRepository.deleteById(id);
    }

    @Override
    public List<Song> getSongfromArtist(String id) {
        Artist artist = artistServices.getArtistId(id);
        return  artist.getSongs();
    }
}
