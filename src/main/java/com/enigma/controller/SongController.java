package com.enigma.controller;

import com.enigma.entity.Artist;
import com.enigma.entity.Song;
import com.enigma.service.impl.ArtistServices;
import com.enigma.service.impl.SongServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class SongController {
    @Autowired
    ObjectMapper objectMapper;
@Autowired
    SongServices songServices;
@Autowired
    ArtistServices artistServices;
    @GetMapping("/song")
    public List<Song> getArtist(){
        return songServices.getAll();
    }
    @CrossOrigin
    @PostMapping("/song")
    public Song saveArtist(@RequestBody Song song){
        return songServices.save( song);
    }
    @GetMapping("/song/{id}")
    public Song getProductById(@PathVariable String id){
        return songServices.getSongId(id);
    }

@CrossOrigin
@GetMapping("artist/{id}/song")
    public List<Song> getstorrebyidandProduct(@PathVariable String id){
        return  songServices.getSongfromArtist(id);
    }

}
