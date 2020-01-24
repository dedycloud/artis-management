//package com.enigma.service;
//
//import com.enigma.entity.Artist;
//import com.enigma.repositories.ArtistRepository;
//import com.enigma.service.impl.ArtistServices;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ArtistServiceImplTest {
//    @Autowired
//    ArtistServices artistServices;
//    @Autowired
//    ArtistRepository artistRepository;
//
//    @Before
//    public void cleanUp(){
//        artistRepository.deleteAll();
//    }
//
//    @Test
//    public void artist_save_expected_created() {
//        Artist artist = new Artist("peterpan","jakatra",new Date());
//        Artist  artist1 = artistServices.save(artist);
//        Artist result = artistRepository.findById(artist1.getId()).get();
//        assertEquals(artist,result);
//    }
//    @Test
//    public void getAllArtist_should_true_whenSizeEqual_2() {
//        Artist artist = new Artist("peterpan","jakatra",new Date());
//        Artist artist1 = new Artist("peterpan","jakatra",new Date());
//        artistServices.save(artist);
//        artistServices.save(artist1);
//        assertEquals(2,artistRepository.findAll().size());
//    }
//    @Test
//    public void Artist_should_get_by_id(){
//        Artist artist = new Artist("peterpan","jakatra",new Date());
//        artistRepository.save(artist);
//        Artist result =  artistServices.getArtistId(artist.getId());
//        assertEquals(artist,result);
//    }
//    @Test
//    public void  whenDeleteByIdFromRepository_should_0_thenDeletingShouldBeSuccessful(){
//        Artist artist = new Artist("peterpan","jakatra",new Date());
//        artistRepository.save(artist);
//        artistServices.deleteArtist(artistRepository.findById(artist.getId()).get().getId());
//        assertEquals(0,artistServices.getAllartist().size());
//    }
//
//
//}