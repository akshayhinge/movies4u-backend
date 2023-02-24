package com.movies4u.mvc.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DownloadRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String username;

	@Column
	private String requestQuery;

	@Column
	private Date date;

	@Column()
	private Integer movieID;

	@Column(length = 15)
	private String media_type;

	@Column(length = 50)
	private String movieName;

	public DownloadRequest() {
	}

	

	public DownloadRequest(String username, String requestQuery, Date date, Integer movieID, String media_type,
			String movieName) {
		super();
		this.username = username;
		this.requestQuery = requestQuery;
		this.date = date;
		this.movieID = movieID;
		this.media_type = media_type;
		this.movieName = movieName;
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

	public String getRequestQuery() {
		return requestQuery;
	}

	public void setRequestQuery(String requestQuery) {
		this.requestQuery = requestQuery;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getMovieID() {
		return movieID;
	}

	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}



	public String getMedia_type() {
		return media_type;
	}



	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}



	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}
