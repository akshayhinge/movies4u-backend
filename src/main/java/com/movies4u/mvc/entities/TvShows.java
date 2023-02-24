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
@Table(name = "tvshows")
public class TvShows {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tvshow_ID", unique = true, nullable = false)
	private Integer tvshowID;

	@Column(name = "tvshows_name", length = 50)
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

	@OneToMany(mappedBy = "tvShows", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<TvShowsComments> comments;

	@OneToMany(mappedBy = "tvShows", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<TvShowsDownload> downloads;

	@ManyToMany(cascade = CascadeType.PERSIST, 
			fetch = FetchType.LAZY, 
			targetEntity = Genre.class)
	@JoinTable(name = "_tvShows_genres", joinColumns = { @JoinColumn(name = "tvshow_id") }, inverseJoinColumns = {
			@JoinColumn(name = "genre_id") })
	private List<Genre> tvshowgenre;

	public TvShows() {
	}

	public TvShows(Integer tvshowID, String original_title, Float popularity, String poster_path, Float vote_average,
			Integer vote_count, Date release_date, String overview, List<TvShowsComments> comments,
			List<TvShowsDownload> downloads, List<Genre> tvshowsgenre) {
		super();
		this.tvshowID = tvshowID;
		this.original_title = original_title;
		this.popularity = popularity;
		this.poster_path = poster_path;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.release_date = release_date;
		this.overview = overview;
		this.comments = comments;
		this.downloads = downloads;
		this.tvshowgenre = tvshowsgenre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Genre> getTvshowgenre() {
		return tvshowgenre;
	}

	public void setTvshowgenre(List<Genre> tvshowgenre) {
		this.tvshowgenre = tvshowgenre;
	}

	public Integer getTvshowID() {
		return tvshowID;
	}

	public void setTvshowID(Integer tvshowID) {
		this.tvshowID = tvshowID;
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

	public List<TvShowsComments> getComments() {
		return comments;
	}

	public void setComments(List<TvShowsComments> comments) {
		this.comments = comments;
	}

	public List<TvShowsDownload> getDownloads() {
		return downloads;
	}

	public void setDownloads(List<TvShowsDownload> downloads) {
		this.downloads = downloads;
	}

	public List<Genre> getGenre() {
		return tvshowgenre;
	}

	public void setGenre(List<Genre> tvshowsgenre) {
		this.tvshowgenre = tvshowsgenre;
	}

	
}
