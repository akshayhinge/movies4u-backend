package com.movies4u.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movies4u.mvc.entities.DownloadRequest;


public interface DownloadRequestrepo extends JpaRepository<DownloadRequest, Long>{

	
}
