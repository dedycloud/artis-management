package com.enigma.service.impl;

import com.enigma.entity.Genre;
import com.enigma.entity.Song;

import java.util.List;

public interface GenreServices {
    Genre save(Genre genre);
    List<Genre> getAll ();
    Genre getGenreId(String id);

}
