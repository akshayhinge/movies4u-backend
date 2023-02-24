package com.movies4u.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies4u.mvc.dao.MoviesDao;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.entities.Result;

@Service
public class MoviesServices {

	@Autowired
	private MoviesDao moviesDao;
	
	public MoviesServices() {}
	
	public Result getmoviesbypage(int page){
		return moviesDao.getMoviesByPage(page);
	}
	
	public Boolean addMovie(Movies movie,List<Long> categoryID) {
		return moviesDao.addmovies(movie,categoryID);
	}
	
	public Movies updateMovieByID(Long id,Movies movies) {
		return moviesDao.updateMovieByID(id, movies);
	}
	
	public Boolean deleteMoviesByid(Long id) {
		return moviesDao.deleteMovieByID(id);
	}
}
