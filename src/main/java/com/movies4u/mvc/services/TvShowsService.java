package com.movies4u.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies4u.mvc.dao.MoviesDao;
import com.movies4u.mvc.dao.TvShowsDao;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.entities.Result;
import com.movies4u.mvc.entities.TvShows;

@Service
public class TvShowsService {

	@Autowired
	private TvShowsDao tvShowsDao;
	
	public TvShowsService() {}
	
	public Result getTvShowsByPage(int page){
		return tvShowsDao.getTvShowsByPage(page);
	}
	
	public Boolean addTvShows(TvShows movie,List<Long> categoryID) {
		return tvShowsDao.addTvShows(movie,categoryID);
	}
	
	public TvShows updateTvShowsByID(Long id,TvShows movies) {
		return tvShowsDao.updateTvShowsByID(id, movies);
	}
	
	public Boolean deletetvShowsByID(Long id) {
		return tvShowsDao.deletetvShowsByID(id);
	}
}
