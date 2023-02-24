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

import com.movies4u.mvc.entities.Genre;
import com.movies4u.mvc.services.GenreServices;

@RestController
@RequestMapping("/genre/")
@CrossOrigin
public class GenreController {

	@Autowired
	private GenreServices categoryServices;
	
	@GetMapping("")
	public ResponseEntity<?> getAllCategories(){
		List<Genre> allCategoriesList = categoryServices.getAllGenres();
		if(allCategoriesList!=null) {
			return ResponseEntity.ok(allCategoriesList);
		}
		return new ResponseEntity<String>("something went wrong...",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addCategory(@RequestBody Genre categoryName){
		 return ResponseEntity.ok(categoryServices.addGenre(categoryName));
	}
	
	@PostMapping("all")
	public ResponseEntity<?> addAllCategory(@RequestBody List<Genre> categories){
		List<Genre> list = categoryServices.addAllGenre(categories);
		if(list!=null) {
			return new ResponseEntity<List<Genre>>(list,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateCategoryById(@PathVariable("id") Long id, @RequestBody Genre category){
		if(id<=0)return new ResponseEntity<String>("ID must be greater than 0",HttpStatus.BAD_REQUEST);
		 Genre result = categoryServices.updateGenreByid(id, category);
		if(result!=null) {
			return new ResponseEntity<Genre>(category,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Something went wrong...",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCategoryByid(@PathVariable Long id){
		if(id<=0)return new ResponseEntity<String>("ID must be greater than 0",HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(categoryServices.deleteGenreByid(id));
	}
}
