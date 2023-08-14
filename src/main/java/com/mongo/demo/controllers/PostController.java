package com.mongo.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.demo.entities.Post;
import com.mongo.demo.repositories.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostRepository repositorie;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		
		List<Post> list = repositorie.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value=("/titlesearch"))
	public ResponseEntity<Post> findByTitle(@RequestParam(value="text",defaultValue = "") String title) {
		
		return ResponseEntity.ok().body(repositorie.findByTitleContainingIgnoreCase(title));
	}
			
	
}
