package com.mongo.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.demo.DTO.UserDTO;
import com.mongo.demo.entities.Post;
import com.mongo.demo.entities.User;
import com.mongo.demo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	UserRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UserDTO> > findAll(){
		
		List<User> list = repository.findAll();
		List<UserDTO> listDTO =  list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable String id){
		Optional<User> user = repository.findById(id);		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public void addUser(@RequestBody User u ) {
		repository.save(u);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable String id) {
		
		repository.deleteById(id);
		
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<Set<Post>> getPosts(@PathVariable String id){
		Optional<User> user = repository.findById(id);	
		User u = user.get();
		 
		
		return ResponseEntity.ok().body(u.getPosts());
	}
	
	
}
