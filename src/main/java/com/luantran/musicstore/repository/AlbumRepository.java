package com.luantran.musicstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luantran.musicstore.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	List<Album> findByGenreName(String name);
	
	List<Album> findByid(Long id);
}

