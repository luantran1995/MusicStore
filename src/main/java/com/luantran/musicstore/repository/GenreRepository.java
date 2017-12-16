package com.luantran.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luantran.musicstore.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
