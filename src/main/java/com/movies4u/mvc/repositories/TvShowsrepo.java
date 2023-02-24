package com.movies4u.mvc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.movies4u.mvc.entities.TvShows;

public interface TvShowsrepo extends JpaRepository<TvShows, Long>{


	public List<TvShows> findByTvshowID(Long tvshowID);
}
