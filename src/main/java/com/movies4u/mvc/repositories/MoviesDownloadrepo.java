package com.movies4u.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies4u.mvc.entities.MoviesDownload;

public interface MoviesDownloadrepo extends JpaRepository<MoviesDownload, Long>{

}
