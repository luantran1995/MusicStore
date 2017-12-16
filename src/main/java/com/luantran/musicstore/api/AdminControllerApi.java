package com.luantran.musicstore.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luantran.musicstore.model.Album;
import com.luantran.musicstore.repository.AlbumRepository;
import com.luantran.musicstore.repository.ArtistRepository;
import com.luantran.musicstore.repository.GenreRepository;

@RestController
@RequestMapping("/api")
public class AdminControllerApi {
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private GenreRepository genreRepository;
	@RequestMapping("/show")
	public List<Album> showAlbum (){
		
		return albumRepository.findAll();
		
	}
	@CrossOrigin(allowedHeaders= {"http://localhost:4200"})
	@RequestMapping(value="/deleteItem/{id}",method=RequestMethod.DELETE)
	public List<Album> deleteItem(@PathVariable("id") Long albumId){
		albumRepository.delete(albumId);
		return  albumRepository.findAll();
		
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET )
	public Album detailItem(@PathVariable("id") Long albumId){
		return albumRepository.findOne(albumId);
	}
	
	
}
