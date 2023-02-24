package com.movies4u.mvc.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.movies4u.mvc.util.DateHandler;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "movie_ID", unique = true, nullable = false)
	private Integer moviesID;

	@Column(name = "Movie_name", length = 50)
	private String original_title;

	@Column()
	private Float popularity;

	@Column(name = "posterImage", length = 200)
	private String poster_path;

	@Column
	private Float vote_average;

	@Column()
	private Integer vote_count;

	@Column()
	@JsonDeserialize(using = DateHandler.class)
	private Date release_date;

	@Column(length = 1000)
	private String overview;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<MoviesComments> comments;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<MoviesDownload> downloads;

	@ManyToMany(cascade = CascadeType.PERSIST, 
			fetch = FetchType.LAZY, 
			targetEntity = Genre.class)
	@JoinTable(name = "_Movies_genres", joinColumns = { @JoinColumn(name = "movies_id") }, inverseJoinColumns = {
			@JoinColumn(name = "genre_id") })
	private List<Genre> moviegenre;

	public Movies() {
	}

	public Movies(Integer moviesID, String original_title, Float popularity, String poster_path, Float vote_average,
			Integer vote_count, Date release_date, String overview, List<MoviesComments> comments,
			List<MoviesDownload> downloads, List<Genre> moviesgenre) {
		super();
		this.moviesID = moviesID;
		this.original_title = original_title;
		this.popularity = popularity;
		this.poster_path = poster_path;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.release_date = release_date;
		this.overview = overview;
		this.comments = comments;
		this.downloads = downloads;
		this.moviegenre = moviesgenre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMoviesID() {
		return moviesID;
	}

	public void setMoviesID(Integer moviesID) {
		this.moviesID = moviesID;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public Float getPopularity() {
		return popularity;
	}

	public void setPopularity(Float popularity) {
		this.popularity = popularity;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public Float getVote_average() {
		return vote_average;
	}

	public void setVote_average(Float vote_average) {
		this.vote_average = vote_average;
	}

	public Integer getVote_count() {
		return vote_count;
	}

	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public List<MoviesComments> getComments() {
		return comments;
	}

	public void setComments(List<MoviesComments> comments) {
		this.comments = comments;
	}

	public List<MoviesDownload> getDownloads() {
		return downloads;
	}

	public void setDownloads(List<MoviesDownload> downloads) {
		this.downloads = downloads;
	}

	public List<Genre> getGenre() {
		return moviegenre;
	}

	public void setGenre(List<Genre> moviesgenre) {
		this.moviegenre = moviesgenre;
	}
	
}