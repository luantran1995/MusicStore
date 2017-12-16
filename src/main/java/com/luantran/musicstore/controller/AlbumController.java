package com.luantran.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luantran.musicstore.model.Album;
import com.luantran.musicstore.model.Genre;
import com.luantran.musicstore.repository.AlbumRepository;
import com.luantran.musicstore.repository.GenreRepository;

@Controller

public class AlbumController extends GeneralController {

	public static final String PARAM_LATESTPHOTO = "LATEST_PHOTO_PARAM";
	public static final String PARAM_BASE_URL = "baseURL";

	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private GenreRepository genreRepository;


	@GetMapping("/genre")
	public String showAlbumByGenreName(@RequestParam String name, Model model, HttpServletRequest request) {
		List<Album> albums = albumRepository.findByGenreName(name);
		List<Genre> genres = genreRepository.findAll();
		
		model.addAttribute(PARAM_BASE_URL, getBaseURL(request));

		model.addAttribute("genres", genres);
		model.addAttribute("albums", albums);
		model.addAttribute("genreName", name);
		return "genre";
	}
	@GetMapping("/viewproduct/{id}")
	public ModelAndView viewProduct(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		model.addAttribute(PARAM_BASE_URL, getBaseURL(request));

		Album album = albumRepository.findOne(id);
		List<Genre> genres = genreRepository.findAll();
		model.addAttribute("genres", genres);
		model.addAttribute("album", album);

		return new ModelAndView("viewproduct");

	}


}
