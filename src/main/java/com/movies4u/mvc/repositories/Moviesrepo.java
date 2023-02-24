package com.movies4u.mvc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.movies4u.mvc.entities.Movies;

public interface Moviesrepo extends JpaRepository<Movies, Long>{


	public List<Movies> findByMoviesID(Long moviesID);
}
