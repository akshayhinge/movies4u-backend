package com.movies4u.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movies4u.mvc.entities.MoviesComments;


public interface MoviesCommentsrepo extends JpaRepository<MoviesComments, Long>{

}
