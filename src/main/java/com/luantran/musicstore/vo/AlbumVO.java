package com.luantran.musicstore.vo;


import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.luantran.musicstore.model.Album;

public class AlbumVO {

	private Long id;

	private String title;
	
	@NotNull
	private double price;

	private String albumArtUrl;
	
	private Long idGenre;

	private String nameGenre;
	
	private Long idArtist;

	private String nameArtist;
	
	private   MultipartFile file;



//	public MultipartFile getFile() {
//		return file;
//	}
//
//	public void setFile(MultipartFile file) {
//		this.file = file;
//	}

	public AlbumVO() {
	}
	
	public AlbumVO(Album album ) {
		this.id = album.getId();
		this.title = album.getTitle();
		this.price = album.getPrice();
		this.albumArtUrl = album.getAlbumArtUrl();
		this.idGenre = album.getGenre().getId();
		this.nameGenre = album.getGenre().getName();
		this.idArtist = album.getArtist().getId();
		this.nameArtist = album.getArtist().getName();
	}

	
	public String getAlbumArtUrl() {
		return albumArtUrl;
	}

	public void setAlbumArtUrl(String albumArtUrl) {
		this.albumArtUrl = albumArtUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	
	public Long getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Long idGenre) {
		this.idGenre = idGenre;
	}

	public String getNameGenre() {
		return nameGenre;
	}

	public void setNameGenre(String nameGenre) {
		this.nameGenre = nameGenre;
	}

	public Long getIdArtist() {
		return idArtist;
	}

	public void setIdArtist(Long idArtist) {
		this.idArtist = idArtist;
	}

	public String getNameArtist() {
		return nameArtist;
	}

	public void setNameArtist(String nameArtist) {
		this.nameArtist = nameArtist;
	}
	
	
	
	
	
}
