package com.movies4u.mvc.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.movies4u.mvc.util.DateHandler;

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
public class TvShowsComments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String comment;
	
	@Column
	@JsonDeserialize(using = DateHandler.class)
	private Date date;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonBackReference
	private TvShows tvShows;
	
	public TvShowsComments() {}


	public TvShowsComments(String username, String comment, Date date, TvShows tvShows) {
		super();
		this.username = username;
		this.comment = comment;
		this.date = date;
		this.tvShows = tvShows;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public TvShows getTvShows() {
		return tvShows;
	}


	public void setTvShows(TvShows tvShows) {
		this.tvShows = tvShows;
	}




	
	
}
