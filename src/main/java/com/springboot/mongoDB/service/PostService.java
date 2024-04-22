package com.springboot.mongoDB.service;

import java.time.LocalDate;
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
	
	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
		maxDate = maxDate.plusDays(1);
		System.out.println("text Service: " + text);
		System.out.println("minDate Service: " + minDate);
		System.out.println("maxDate Service: " + maxDate);
		System.out.println("Antes fullSearch");
		System.out.println("fullSearch Service: " + postRepository.fullSearch(text, minDate, maxDate));
		System.out.println("Pós fullSearch");
		return postRepository.fullSearch(text, minDate, maxDate);
		
	}
}

