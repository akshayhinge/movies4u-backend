package com.movies4u.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.movies4u.mvc.entities.Genre;
import com.movies4u.mvc.entities.Result;
import com.movies4u.mvc.entities.TvShows;
import com.movies4u.mvc.repositories.Genrerepo;
import com.movies4u.mvc.repositories.TvShowsrepo;

@Repository
public class TvShowsDao {
	
	@Autowired
	private TvShowsrepo tvShowsrepo;
	
	@Autowired
	private Genrerepo categoryrepo;
	//get movies by pageable form
	public Result getTvShowsByPage(int page){
		try {
			//20 records per page
		   Page<TvShows> all = tvShowsrepo.findAll(PageRequest.of(page-1, 20));
		   Result result=new Result(all.getNumber()+1,
				   all.getContent(),
				   all.getTotalPages(),
				   all.getTotalElements());
		  return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

//	add single movie 
	public Boolean addTvShows(TvShows tvShows,List<Long> categoryID) {
		try {
			List<Genre> categoryList=new ArrayList<>();
			for(Long id:  categoryID) {
				Genre category = categoryrepo.findByGenreID(id).get(0);				
				categoryList.add(category);
				
			}
			tvShows.setGenre(categoryList);
			tvShowsrepo.save(tvShows);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	update movie fields data
	public TvShows updateTvShowsByID(Long id, TvShows tvShows) {
		try {
			Optional<TvShows> optionalData = tvShowsrepo.findById(id);
			TvShows oldtvShows=new TvShows();
			oldtvShows=optionalData.get(); 
			if(tvShows.getOriginal_title()!=null) {
				oldtvShows.setOriginal_title(tvShows.getOriginal_title());
			}
			if(tvShows.getTvshowID()!=null) {
				oldtvShows.setTvshowID(tvShows.getTvshowID());
			}
			if(tvShows.getPopularity()!=null) {
				oldtvShows.setPopularity(tvShows.getPopularity());
			}
			if(tvShows.getPoster_path()!=null) {
				oldtvShows.setPoster_path(tvShows.getPoster_path());
			}
			if(tvShows.getVote_average()!=null) {
				oldtvShows.setVote_average(tvShows.getVote_average());
			}
			if(tvShows.getVote_count()!=null) {
				oldtvShows.setVote_count(tvShows.getVote_count());
			}
			if(tvShows.getRelease_date()!=null) {
				oldtvShows.setRelease_date(tvShows.getRelease_date());
			}
			if(tvShows.getOverview()!=null) {
				oldtvShows.setOverview(tvShows.getOverview());
			}
			return tvShowsrepo.save(oldtvShows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	deleting movie by id
	public Boolean deletetvShowsByID(Long id) {
		try {
			tvShowsrepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
