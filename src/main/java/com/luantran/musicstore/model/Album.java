package com.luantran.musicstore.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String title;
	
	@NotNull
	private double price;
	
	@Column(length = 1024)
	private String albumArtUrl;
	
	@OneToMany
	private Map<Integer, CartItem> cartItems;

	


	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public String getAlbumArtUrl() {
		return albumArtUrl;
	}

	public String setAlbumArtUrl(String albumArtUrl) {
		return this.albumArtUrl = albumArtUrl;
	}

	@ManyToOne
	private Genre genre;

	@ManyToOne
	private Artist artist;

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


	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album(Long id) {
		this.id = id;
	}
	
	public Album() {
	}

}


