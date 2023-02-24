package com.movies4u.mvc.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.movies4u.mvc.entities.Genre;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.entities.Result;
import com.movies4u.mvc.repositories.Genrerepo;
import com.movies4u.mvc.repositories.Moviesrepo;

@Repository
public class MoviesDao {
	
	@Autowired
	private Moviesrepo moviesrepo;
	
	@Autowired
	private Genrerepo categoryrepo;
	//get movies by pageable form
	public Result getMoviesByPage(int page){
		try {
			//20 records per page
		   Page<Movies> all = moviesrepo.findAll(PageRequest.of(page-1, 20));
		   Result result=new Result(all.getNumber()+1,
				   all.getContent(),
				   all.getTotalPages(),
				   all.getTotalElements());
		  return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

//	add single movie 
	public Boolean addmovies(Movies movie,List<Long> categoryID) {
		try {
			List<Genre> categoryList=new ArrayList<Genre>();
			for(Long id:  categoryID) {
				Genre category = categoryrepo.findByGenreID(id).get(0);				
				categoryList.add(category);
			}
			movie.setGenre(categoryList);
			 moviesrepo.save(movie);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
//	update movie fields data
	public Movies updateMovieByID(Long id, Movies movie) {
		try {
			Optional<Movies> optionalData = moviesrepo.findById(id);
			Movies oldMovie=new Movies();
			oldMovie=optionalData.get(); 
			if(movie.getOriginal_title()!=null) {
				oldMovie.setOriginal_title(movie.getOriginal_title());
			}
			if(movie.getMoviesID()!=null) {
				oldMovie.setMoviesID(movie.getMoviesID());
			}
			if(movie.getPopularity()!=null) {
				oldMovie.setPopularity(movie.getPopularity());
			}
			if(movie.getPoster_path()!=null) {
				oldMovie.setPoster_path(movie.getPoster_path());
			}
			if(movie.getVote_average()!=null) {
				oldMovie.setVote_average(movie.getVote_average());
			}
			if(movie.getVote_count()!=null) {
				oldMovie.setVote_count(movie.getVote_count());
			}
			if(movie.getRelease_date()!=null) {
				oldMovie.setRelease_date(movie.getRelease_date());
			}
			if(movie.getOverview()!=null) {
				oldMovie.setOverview(movie.getOverview());
			}
			return moviesrepo.save(oldMovie);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
//	deleting movie by id
	public Boolean deleteMovieByID(Long id) {
		try {
			moviesrepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
