package com.springboot.mongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongoDB.domain.entities.Post;
import com.springboot.mongoDB.repository.PostRepository;
import com.springboot.mongoDB.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
//	public List<Post> findByTitle(String text) {
//		return postRepository.findByTitleContainingIgnoreCase(text);
//	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitle(text);
	}
}

