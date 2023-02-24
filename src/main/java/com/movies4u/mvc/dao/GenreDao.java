package com.movies4u.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movies4u.mvc.entities.Genre;
import com.movies4u.mvc.repositories.Genrerepo;


@Repository
public class GenreDao {

	@Autowired
	private Genrerepo genrerepo;
	
	public List<Genre> getAllGenres(){
		try {
			
			return genrerepo.findAll();
		} catch (Exception e) {
			System.out.println("Exception :"+e.getMessage());
			e.getStackTrace();
		}
		return null;
	}
	
	public Genre addGenre(Genre Genre) {
		try {
			 return genrerepo.save(Genre);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	
	public List<Genre> addAllGenre(List<Genre> categories) {
		try {
			return genrerepo.saveAll(categories);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	public Genre updateGenreByid(Long id,Genre Genre) {
		try {
			Genre oldGenre = genrerepo.findById(id).get();
			if(Genre.getName()!=null) {
				oldGenre.setName(Genre.getName());
			}
			return genrerepo.saveAndFlush(oldGenre);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	public Boolean deleteGenreByid(Long id) {
		try {
			genrerepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
			
		}
	}  
	
	
	

	
}
