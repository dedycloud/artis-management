package com.enigma.service;

import com.enigma.entity.Artist;
import com.enigma.entity.Song;
import com.enigma.repositories.ArtistRepository;
import com.enigma.service.impl.ArtistServices;
import com.enigma.spesification.ArtistSpesification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistServices {
@Autowired
    ArtistRepository artistRepository;
    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getAllartist() {
        return  artistRepository.findAll();
    }



    @Override
    public List<Artist> GetAllByIdSArtist(String keyword) {
        return artistRepository.findAllByIdContains(keyword);
    }

    @Override
    public Artist saveArtist(Artist artist) {
            for (Song song : artist.getSongs()) {
                song.setArtistId(artist);
            }
            return artistRepository.save(artist);
    }
    @Override
    public Page<Artist> getAll(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }

    @Override
    public Page<Artist> GetAlLArtisttWithSpesification(Pageable pageable, Artist artist) {
        return artistRepository.findAll(ArtistSpesification.findByCriterias(artist),pageable);
    }

    @Override
    public Artist getArtistId(String id) {
        if (!artistRepository.findById(id).isPresent()) {
            return new Artist();
        }
        return artistRepository.findById(id).get();
    }
}
