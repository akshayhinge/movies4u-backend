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
import com.movies4u.mvc.entities.DownloadRequest;
import com.movies4u.mvc.entities.Result;
import com.movies4u.mvc.services.DownloadRequestService;

@RestController
@RequestMapping("/downloadrequest/")
@CrossOrigin
public class DownloadRequestController {

	@Autowired
	private DownloadRequestService requestService;
	
	@GetMapping("{page}")
	public ResponseEntity<?> getByMovieid(@PathVariable("page") Short page){
		if(page<=0) {return new ResponseEntity<String>("Movie id must be greater than 0",HttpStatus.BAD_REQUEST);}
		Result list = requestService.getByMovieid(page);
		if(list!=null) {
			return new ResponseEntity<Result>(list,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addByid(@RequestBody DownloadRequest request){
		DownloadRequest savedRequest = requestService.addByMovieid(request);
		if(savedRequest!=null) {
			return new ResponseEntity<DownloadRequest>(savedRequest,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateByid(@PathVariable("id") Long id,@RequestBody DownloadRequest request){
		if(id<=0) {return new ResponseEntity<String>("id must be greater than 0",HttpStatus.BAD_REQUEST);}
		Boolean isUpdated = requestService.updateByMovieId(id, request);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("{id}") 
	public ResponseEntity<?> deleteByid(@PathVariable("id") Long id){
		if(id<=0) {return new ResponseEntity<String>("id must be greater than 0",HttpStatus.BAD_REQUEST);}
		Boolean isdeleted = requestService.deleteByMovieId(id);
		if(isdeleted) {
			return new ResponseEntity<Boolean>(isdeleted,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
