package com.movies4u.mvc.dao;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movies4u.mvc.entities.MoviesComments;
import com.movies4u.mvc.entities.TvShows;
import com.movies4u.mvc.entities.TvShowsComments;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.repositories.MoviesCommentsrepo;
import com.movies4u.mvc.repositories.TvShowsCommentsrepo;
import com.movies4u.mvc.repositories.TvShowsrepo;

@Repository
public class TvShowsCommentsDao {

	@Autowired
	private TvShowsrepo tvShowsrepo;
	
	@Autowired 
	private TvShowsCommentsrepo commentsrepo;
	
	public List<TvShowsComments> getCommentsByMoviesID(Long id){
		try {
			List<TvShows> movie = tvShowsrepo.findByTvshowID(id);
			return movie.get(0).getComments();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}  
	
	
	public TvShowsComments addCommentByMovieID(Long id, TvShowsComments comment) {
		try {
			List<TvShows> movies = tvShowsrepo.findByTvshowID(id);
			TvShows movie=movies.get(0);

			comment.setTvShows(movie);
			comment.setDate(Date.from(Instant.now()));
			return commentsrepo.saveAndFlush(comment);
			
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Boolean deleteCommentByID(Long id) {
		try {
			commentsrepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
