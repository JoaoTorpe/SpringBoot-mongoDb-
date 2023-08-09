package com.mongo.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.demo.entities.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>  {

}
