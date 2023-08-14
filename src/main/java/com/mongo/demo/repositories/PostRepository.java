package com.mongo.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.demo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>  {

	public Post findByTitleContainingIgnoreCase(String text);
	
}
