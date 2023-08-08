package com.mongo.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.demo.entities.User;
import com.mongo.demo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	UserRepository repository;
	
	@GetMapping
	public ResponseEntity<List<User> > findAll(){
		
		List<User> list = repository.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	
}
