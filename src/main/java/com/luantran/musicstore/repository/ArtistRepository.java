package com.luantran.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luantran.musicstore.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
