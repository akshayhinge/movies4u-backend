package com.movies4u.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies4u.mvc.dao.GenreDao;
import com.movies4u.mvc.entities.Genre;

@Service
public class GenreServices {

	@Autowired
	private GenreDao genreDao;
	
	public List<Genre> getAllGenres(){
		return genreDao.getAllGenres();
	}
	
	public Genre addGenre(Genre category) {
		return genreDao.addGenre(category);
	}
	
	public Genre updateGenreByid(Long id,Genre category) {
		return genreDao.updateGenreByid(id, category);
	}
	public Boolean deleteGenreByid(Long id) {
		return genreDao.deleteGenreByid(id);
	}
	public List<Genre> addAllGenre(List<Genre> categories) {
		return genreDao.addAllGenre(categories);
	}
}
