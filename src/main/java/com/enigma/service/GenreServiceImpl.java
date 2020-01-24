package com.enigma.service;

import com.enigma.entity.Artist;
import com.enigma.entity.Genre;
import com.enigma.entity.Song;
import com.enigma.repositories.GenreRepository;
import com.enigma.service.impl.GenreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreServices {

    @Autowired
    GenreServices genreServices;
    @Autowired
    GenreRepository genreRepository;

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreId(String id) {
        if (!genreRepository.findById(id).isPresent()) {
            return new Genre();
        }
        return genreRepository.findById(id).get();
    }
}
