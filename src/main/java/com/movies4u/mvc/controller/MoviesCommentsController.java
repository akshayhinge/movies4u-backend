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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies4u.mvc.entities.MoviesComments;
import com.movies4u.mvc.services.MoviesCommentServices;

@RestController
@RequestMapping("/movies/comment/")
@CrossOrigin
public class MoviesCommentsController {

	@Autowired
	private MoviesCommentServices commentServices;
	
	@GetMapping("{id}")
	public ResponseEntity<?> getCommentsByMoviesID(@PathVariable("id") Long id){
		if(id<=0) return new ResponseEntity<String>("Movie id must be greater than 0",HttpStatus.BAD_REQUEST);
		List<MoviesComments> comments = commentServices.getCommentsByMoviesID(id);
		if(comments!=null) {
			return ResponseEntity.ok(comments);
		}
		return new ResponseEntity<String>("Something went wrong...Try Again",HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("{id}")
	public ResponseEntity<?> addCommentByMovieID(@PathVariable("id") Long id,@RequestBody MoviesComments comment){
		if(id<=0) return new ResponseEntity<String>("Movie id must be greater than 0",HttpStatus.BAD_REQUEST);
		MoviesComments Savedcomment = commentServices.addCommentByMovieID(id, comment);
		if(Savedcomment!=null) {
			return new ResponseEntity<MoviesComments>(Savedcomment,HttpStatus.CREATED);
		}
		return ResponseEntity.internalServerError().body("Something went wrong");
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCommentByid(@PathVariable("id") Long id){
		if(id<=0) return new ResponseEntity<String>("Comment id must be greater than 0",HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(commentServices.deleteCommentByid(id));
	}
	
}
