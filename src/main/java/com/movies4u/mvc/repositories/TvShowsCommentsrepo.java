package com.movies4u.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movies4u.mvc.entities.TvShowsComments;


public interface TvShowsCommentsrepo extends JpaRepository<TvShowsComments, Long>{

}
