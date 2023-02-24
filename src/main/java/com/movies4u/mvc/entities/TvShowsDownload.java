package com.movies4u.mvc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class TvShowsDownload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(nullable = false)
	private String language;

	@Column
	private String download_link;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonBackReference
	private TvShows tvShows;

	public TvShowsDownload() {
	}

	public TvShowsDownload(String name, String language, String download_link, TvShows tvShows) {
		super();
		this.name = name;
		this.language = language;
		this.download_link = download_link;
		this.tvShows = tvShows;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDownload_link() {
		return download_link;
	}

	public void setDownload_link(String download_link) {
		this.download_link = download_link;
	}

	public TvShows getTvShows() {
		return tvShows;
	}

	public void setTvShows(TvShows tvShows) {
		this.tvShows = tvShows;
	}

}
