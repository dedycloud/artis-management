package com.enigma.repositories;

import com.enigma.entity.Artist;
import com.enigma.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,String>, JpaSpecificationExecutor<Artist> {
    public List<Artist> findAllByIdContains(String keyword);

}
