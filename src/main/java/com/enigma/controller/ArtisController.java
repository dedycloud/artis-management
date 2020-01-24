package com.enigma.controller;

import com.enigma.entity.Artist;
import com.enigma.entity.Song;
import com.enigma.service.ArtistServiceImpl;
import com.enigma.service.impl.ArtistServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class ArtisController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ArtistServices artistServices;

    @GetMapping("/Artist")
    public Page<Artist> getArtist(@RequestParam Integer size, @RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        return artistServices.getAll(pageable);
    }

    @GetMapping("/Artist-list")
    public List<Artist> getArtist() {
        return artistServices.getAllartist();
    }

    @PostMapping("/Artist-save")
    public Artist saveArtist(@RequestBody Artist artist) {
        return artistServices.save(artist);
    }
    @PostMapping("/Artist")
    public Artist saveArtistAndSong(@RequestBody Artist artist) {
        return artistServices.saveArtist(artist);
    }
    @GetMapping("/Artist/{id}")
    public Artist getProductById(@PathVariable String id) {
        return artistServices.getArtistId(id);
    }
    @GetMapping("/Artist-search-spesification")
    public Page<Artist> getListArtistWithSpesification(@RequestParam Integer size, @RequestParam Integer page, @RequestBody Artist artist) {
        Pageable pageable = PageRequest.of(page, size);
        return artistServices.GetAlLArtisttWithSpesification(pageable, artist);
    }
    @CrossOrigin
    @PostMapping("/artist-image")
    public Artist saveArtists(@RequestPart MultipartFile file, @RequestPart String artis) throws IOException {
//        System.out.println(objectMapper.readValue(artis, Artist.class)  );
        Artist artist = artistServices.save(objectMapper.readValue(artis, Artist.class));
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
           // file.getOriginalFilename(); untuk ambil nama aslinya
            Path path = Paths.get("E:/nginx/html/img/" + artist.getId() + ".jpg" );
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return artist;
    }
    @GetMapping("/song-artist/{keyword}")
    public List<Artist> getLisSongtByIdArtis(@PathVariable String keyword){
        return artistServices.GetAllByIdSArtist(keyword);
    }
}
