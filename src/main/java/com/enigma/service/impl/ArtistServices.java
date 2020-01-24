package com.enigma.service.impl;

import com.enigma.entity.Artist;
import com.enigma.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArtistServices {

    Artist save(Artist artist);
    Artist saveArtist(Artist artist);
    Page<Artist> getAll(Pageable pageable);

    List<Artist> getAllartist();
    public Page<Artist> GetAlLArtisttWithSpesification(Pageable pageable, Artist artist);

    Artist getArtistId(String id);
    List<Artist> GetAllByIdSArtist(String Keyword);
}

