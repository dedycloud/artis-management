//package com.enigma.controller;
//
//import com.enigma.entity.Artist;
//import com.enigma.repositories.ArtistRepository;
//import com.enigma.service.impl.ArtistServices;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//
//public class ArtisControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//@Autowired
//    ArtistRepository artistRepository;
//@Autowired
//    ArtistServices artistServices;
//
//
//    @Test
//    public void saveUser_is_ok()throws  Exception  {
//        ObjectMapper mapper = new  ObjectMapper();
//        Artist artist = new Artist("peterpan","jakatra",new Date());
//        mockMvc.perform(post("/Artist")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(artist))).andExpect(status().isOk());
//    }
//
//    @Test
//    public void save_artist_should_exist_in_Db() throws  Exception {
//        ObjectMapper mapper = new  ObjectMapper();
//        Artist artist = new Artist("peterpan","jakatra",new Date());
//        String response=    mockMvc.perform(post("/Artist")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(artist))).andReturn().getResponse().getContentAsString();
//        artist = new ObjectMapper().readValue(response,Artist.class);
//        Assert.assertEquals(artist, artistRepository.findById(artist.getId()).get());
//    }
////    @Test
////    public void get_All_Atist_when_CountArtist_2() throws Exception {
////        List<Artist> artists = new ArrayList<>();
////        artists.add( new Artist("peterpan","jakatra",new Date()));
////        artists.add( new Artist("sheilaon7","jakatra-selatan",new Date()));
////        when(artistRepository.findAll()).thenReturn(artists);
////        mockMvc.perform(MockMvcRequestBuilders.get("/Artist-list")
////                .contentType(MediaType.APPLICATION_JSON)
////        ).andExpect(jsonPath("$.id", hasSize(2))).andDo(print());
////    }
//
//    @Test
//    public void can_get_Artist_ById_isok() throws Exception
//    {
//        Artist artist = new Artist("peterpan","jakatra",new Date());
//        mockMvc.perform( MockMvcRequestBuilders
//                .get("/Artist/{id}", 1)
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(artist.getId()));
//    }
//
////contoh json mock get all data atau pageable
//
////            mockMvc.perform( MockMvcRequestBuilders.get("/Artist/{id}", 1).andReturn().getResponse().getContentAsString();
////            List<artis> ar=objectMapper.READVALUE(RES,new typereferesnse<list<artis>(){})
//
//}