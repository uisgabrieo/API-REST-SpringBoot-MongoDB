package com.springboot.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongoDB.domain.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
