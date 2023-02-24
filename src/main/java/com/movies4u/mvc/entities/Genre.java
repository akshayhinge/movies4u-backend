package com.movies4u.mvc.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(unique = true)
	private Integer genreID;

	@Column(nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "moviegenre", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Movies.class)
	@JsonIgnore
	private List<Movies> movies;

	@ManyToMany(mappedBy = "tvshowgenre", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = TvShows.class)
	@JsonIgnore
	private List<TvShows> tvshows;

	public Genre() {
	}

	public Genre(Integer genreID, String name, List<Movies> movies, List<TvShows> tvshows) {
		super();
		this.genreID = genreID;
		this.name = name;
		this.movies = movies;
		this.tvshows = tvshows;
	}

	public List<TvShows> getTvshows() {
		return tvshows;
	}

	public void setTvshows(List<TvShows> tvshows) {
		this.tvshows = tvshows;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGenreID() {
		return genreID;
	}

	public void setGenreID(Integer genreID) {
		this.genreID = genreID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}

}
