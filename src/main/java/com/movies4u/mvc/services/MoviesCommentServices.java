package com.movies4u.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies4u.mvc.dao.MoviesCommentsDao;
import com.movies4u.mvc.entities.MoviesComments;

@Service
public class MoviesCommentServices {

	@Autowired
	private MoviesCommentsDao commentsDao;
	
	public List<MoviesComments> getCommentsByMoviesID(Long id){
		return commentsDao.getCommentsByMoviesID(id);
	} 
	
	public MoviesComments addCommentByMovieID(Long id,MoviesComments comment) {
		return commentsDao.addCommentByMovieID(id, comment);
	}
	
	public Boolean deleteCommentByid(Long id) {
		return commentsDao.deleteCommentByID(id);
	}
	
}
