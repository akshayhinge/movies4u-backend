package com.movies4u.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies4u.mvc.dao.MoviesCommentsDao;
import com.movies4u.mvc.dao.TvShowsCommentsDao;
import com.movies4u.mvc.dao.TvShowsDownloadDao;
import com.movies4u.mvc.entities.MoviesComments;
import com.movies4u.mvc.entities.TvShowsComments;

@Service
public class TvShowsCommentServices {

	@Autowired
	private TvShowsCommentsDao commentsDao;
	
	public List<TvShowsComments> getCommentsByMoviesID(Long id){
		return commentsDao.getCommentsByMoviesID(id);
	} 
	
	public TvShowsComments addCommentByMovieID(Long id,TvShowsComments comment) {
		return commentsDao.addCommentByMovieID(id, comment);
	}
	
	public Boolean deleteCommentByid(Long id) {
		return commentsDao.deleteCommentByID(id);
	}
	
}
