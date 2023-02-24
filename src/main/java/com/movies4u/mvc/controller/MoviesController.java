package com.movies4u.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movies4u.mvc.entities.Movies;
import com.movies4u.mvc.services.MoviesServices;

@RestController
@RequestMapping("/movies/")
@CrossOrigin(origins = "http://localhost:4200")
public class MoviesController {
	
	@Autowired
	private MoviesServices moviesServices;
	

	@GetMapping("{page}")
	public ResponseEntity<?> getmoviesbypage(@PathVariable("page") Integer page){
		if(page<=0)return new ResponseEntity<String>("page must be greater than 0",HttpStatus.BAD_REQUEST);
		return (ResponseEntity.ok(moviesServices.getmoviesbypage(page)));
	}
	
	@PostMapping("/genreID/{id}")
	public Boolean addMovies(@PathVariable("id") List<Long> categoryid,@RequestBody Movies movie){
			  if(categoryid==null) new ResponseEntity<String>("Categories must be specified...",HttpStatus.BAD_REQUEST);
			   return moviesServices.addMovie(movie,categoryid);
//			  if(isadded) {
//				  return new ResponseEntity<Boolean>(isadded,HttpStatus.CREATED);
//			  }
//			  return new ResponseEntity<String>("Failed to add Movie ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateMovieByID(@PathVariable("id") Long id,@RequestBody Movies movie){
		if(id<=0)return new ResponseEntity<String>("ID must be greater than 0",HttpStatus.BAD_REQUEST);
		  Movies movies = moviesServices.updateMovieByID(id,  movie);
		  if(movies!=null) {
			  return ResponseEntity.ok(movies);
		  }
		  return new ResponseEntity<String>("something went wrong...",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteMovieByID(@PathVariable("id") Long id){
		if(id<=0)return new ResponseEntity<String>("ID must be greater than 0",HttpStatus.BAD_REQUEST);
		Boolean isdeleted = moviesServices.deleteMoviesByid(id);
		if(isdeleted) {
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	
	
	
}
