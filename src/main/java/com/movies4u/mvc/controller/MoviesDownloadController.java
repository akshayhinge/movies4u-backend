package com.movies4u.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.movies4u.mvc.entities.MoviesDownload;
import com.movies4u.mvc.entities.Result;
import com.movies4u.mvc.services.MoviesDownloadServices;

@RestController
@RequestMapping("/movies/download")
@CrossOrigin
public class MoviesDownloadController {

	@Autowired
	private MoviesDownloadServices downloadServices;
	
	@GetMapping("{id}")
	public ResponseEntity<?> getDownloadByMoviesID(@PathVariable Long id){
		if(id<=0) return new ResponseEntity<String>("Movie id must be greater than 0",HttpStatus.BAD_REQUEST);
		List<MoviesDownload> Downloadlist = downloadServices.getDownloadByMoviesID(id);
		if(Downloadlist!=null) {
			return ResponseEntity.ok(Downloadlist);
		}
		return new ResponseEntity<String>("something went wrong... ",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("page/{page}")
	public ResponseEntity<?> getAllDownloadsByPage(@PathVariable("page") Integer page){
		if(page<=0) return new ResponseEntity<String>("page must be greater than 0",HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(downloadServices.getAllMoviesByPage(page));
	}
	 
	@PostMapping("{id}")
	public ResponseEntity<?> addDownloadByMoviesID(@PathVariable("id") Long id,@RequestBody MoviesDownload download){
		if(id<=0) return new ResponseEntity<String>("download id must be greater than 0",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<MoviesDownload>(downloadServices.addDownloadByMoviesID(id, download),HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateDownloadByid(@PathVariable("id") Long id,@RequestBody MoviesDownload download){
		if(id<=0) return new ResponseEntity<String>("download id must be greater than 0",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Boolean>(downloadServices.updateDownloadByid(id, download),HttpStatus.CREATED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteDownloadByid(@PathVariable("id") Long id){
		if(id<=0) return new ResponseEntity<String>("download id must be greater than 0",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Boolean>(downloadServices.deleteDownloadByid(id),HttpStatus.OK);
	}
}
