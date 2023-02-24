package com.movies4u.mvc.dao;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movies4u.mvc.entities.MoviesComments;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.repositories.MoviesCommentsrepo;
import com.movies4u.mvc.repositories.Moviesrepo;

@Repository
public class MoviesCommentsDao {

	@Autowired
	private Moviesrepo moviesrepo;
	
	@Autowired 
	private MoviesCommentsrepo commentsrepo;
	
	public List<MoviesComments> getCommentsByMoviesID(Long id){
		try {
			List<Movies> movie = moviesrepo.findByMoviesID(id);
			return movie.get(0).getComments();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}  
	
	
	public MoviesComments addCommentByMovieID(Long id, MoviesComments comment) {
		try {
			List<Movies> movies = moviesrepo.findByMoviesID(id);
			Movies movie=movies.get(0);

			comment.setMovie(movie);
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
