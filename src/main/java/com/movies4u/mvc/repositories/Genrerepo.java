package com.movies4u.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies4u.mvc.entities.Genre;

public interface Genrerepo extends JpaRepository<Genre, Long>{

	public List<Genre> findByName(String name);
	
	public List<Genre> findByGenreID(Long id);
}
