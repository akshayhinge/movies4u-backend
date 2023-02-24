package com.movies4u.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.movies4u.mvc.entities.MoviesDownload;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.entities.Result;
import com.movies4u.mvc.entities.TvShows;
import com.movies4u.mvc.repositories.MoviesDownloadrepo;
import com.movies4u.mvc.repositories.Moviesrepo;
import com.movies4u.mvc.repositories.TvShowsrepo;

@Repository
public class MoviesDownloadDao {

	@Autowired
	private MoviesDownloadrepo downloadrepo;

	@Autowired
	private Moviesrepo moviesrepo;

	public List<MoviesDownload> getDownloadByMoviesID(Long id) {
		try {
			List<Movies> movies = moviesrepo.findByMoviesID(id);
			return movies.get(0).getDownloads();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;

	}

	public Result getAllDownloadByPage(Integer page) {
		try {
			Page<MoviesDownload> all = downloadrepo.findAll(PageRequest.of(page - 1, 20));
			Result result = new Result(all.getNumber() + 1, all.getContent(), all.getTotalPages(),
					all.getTotalElements());
			return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public MoviesDownload addDownloadByMoviesID(Long id, MoviesDownload download) {
		try {

			List<Movies> moviesList = moviesrepo.findByMoviesID(id);
			Movies movie = moviesList.get(0);
			download.setMovie(movie);

			return downloadrepo.saveAndFlush(download);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Boolean updateDownloadByid(Long id, MoviesDownload download) {
		try {
			Optional<MoviesDownload> downlaodOptional = downloadrepo.findById(id);
			MoviesDownload oldDownload = downlaodOptional.get();
			if (download.getName() != null) {
				oldDownload.setName(download.getName());
			}
			if (download.getLanguage() != null) {
				oldDownload.setLanguage(download.getLanguage());
			}
			if (download.getDownload_link() != null) {
				oldDownload.setDownload_link(download.getDownload_link());
			}
			downloadrepo.save(oldDownload);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Boolean DeleteDownloadByid(Long id) {
		try {
			downloadrepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
