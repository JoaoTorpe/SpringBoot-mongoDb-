package com.mongo.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.demo.entities.User;

public interface UserRepository extends MongoRepository<User, String>  {

}
