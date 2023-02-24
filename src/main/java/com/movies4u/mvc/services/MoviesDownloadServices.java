package com.movies4u.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies4u.mvc.dao.MoviesDownloadDao;
import com.movies4u.mvc.entities.MoviesDownload;
import com.movies4u.mvc.entities.Result;

@Service
public class MoviesDownloadServices {

	@Autowired
	private MoviesDownloadDao downloadDao;
	
	public Result getAllMoviesByPage(Integer page){
		return downloadDao.getAllDownloadByPage(page);
	}
	public List<MoviesDownload> getDownloadByMoviesID(Long id){
		return downloadDao.getDownloadByMoviesID(id);
	}
	
	public MoviesDownload addDownloadByMoviesID(Long id,MoviesDownload download) {
		return downloadDao.addDownloadByMoviesID(id, download);
	}
	
	public Boolean updateDownloadByid(Long id,MoviesDownload download) {
		return downloadDao.updateDownloadByid(id, download);
	}
	
	public Boolean deleteDownloadByid(Long id) {
		return downloadDao.DeleteDownloadByid(id);
	}
}
