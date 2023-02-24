package com.movies4u.mvc.dao;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.movies4u.mvc.entities.DownloadRequest;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.entities.Result;
import com.movies4u.mvc.repositories.DownloadRequestrepo;
import com.movies4u.mvc.repositories.MoviesDownloadrepo;
import com.movies4u.mvc.repositories.Moviesrepo;

@Repository
public class DownloadRequestDao {

	@Autowired
	private DownloadRequestrepo downloadRequestrepo;

	@Autowired
	private Moviesrepo moviesrepo;

	public Result getDownloadRequestByPage(Short page) {
		try {

			Page<DownloadRequest> all = downloadRequestrepo
					.findAll(PageRequest.of(page-1, 20, Sort.by("date").descending()));
			Result result = new Result(all.getNumber() + 1, all.getContent(), all.getTotalPages(),
					all.getTotalElements());
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public DownloadRequest addByMoviesID(DownloadRequest downloadRequest) {
		try {
			downloadRequest.setDate(Date.from(Instant.now()));
			return downloadRequestrepo.save(downloadRequest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Boolean updateByid(Long id, DownloadRequest Newrequest) {
		try {
			DownloadRequest Oldrequest = downloadRequestrepo.findById(id).get();
			if (Newrequest.getUsername() != null) {
				Oldrequest.setUsername(Newrequest.getUsername());
			}
			if (Newrequest.getRequestQuery() != null) {
				Oldrequest.setRequestQuery(Newrequest.getRequestQuery());
			}
			downloadRequestrepo.save(Oldrequest);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Boolean deleteByid(Long id) {
		try {
			downloadRequestrepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
