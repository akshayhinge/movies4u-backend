package com.movies4u.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies4u.mvc.dao.DownloadRequestDao;
import com.movies4u.mvc.entities.DownloadRequest;
import com.movies4u.mvc.entities.Result;

@Service
public class DownloadRequestService {

	@Autowired
	private DownloadRequestDao requestDao;
	
	public Result getByMovieid(Short page){
		return requestDao.getDownloadRequestByPage(page);
	}
	
	public DownloadRequest addByMovieid(DownloadRequest request) {
		return requestDao.addByMoviesID(request);
	}
	
	public Boolean updateByMovieId(Long id, DownloadRequest request) {
		return requestDao.updateByid(id, request);
	}
	
	public Boolean deleteByMovieId(Long id) {
		return requestDao.deleteByid(id);
	}
}
