//package com.enigma.service;
//
//import com.enigma.entity.Artist;
//import com.enigma.entity.Song;
//import com.enigma.repositories.ArtistRepository;
//import com.enigma.repositories.SongRepository;
//import com.enigma.service.impl.ArtistServices;
//import com.enigma.service.impl.SongServices;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SongServiceImplTest {
//    @Autowired
//    SongServices songServices;
//    @Autowired
//    SongRepository songRepository;
//
//    @Before
//    public void cleanUp(){
//        songRepository.deleteAll();
//    }
//
//    @Test
//    public void song_save_expected_created() {
//        Song song = new Song("bertahan disana");
//        Song  song1 = songServices.save(song);
//        Song result = songRepository.findById(song1.getId()).get();
//        assertEquals(song,result);
//    }
//    @Test
//    public void getAllSong_should_true_whenSizeEqual_2() {
//        Song song = new Song("bertahan disana");
//        Song song1 = new Song("bertahan disini");
//        songServices.save(song);
//        songServices.save(song1);
//        assertEquals(2,songRepository.findAll().size());
//    }
//    @Test
//    public void Song_should_get_by_id(){
//        Song song = new Song("bertahan disana");
//        songRepository.save(song);
//        Song result =  songServices.getSongId(song.getId());
//        assertEquals(song,result);
//    }
//    @Test
//    public void  whenDeleteByIdFromRepository_should_0_thenDeletingShouldBeSuccessful(){
//        Song song = new Song("bertahan disana");
//        songRepository.save(song);
//        songServices.deleteSong(songRepository.findById(song.getId()).get().getId());
//        assertEquals(0,songServices.getAll().size());
//    }
//}