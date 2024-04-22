package com.springboot.mongoDB.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongoDB.domain.entities.Post;
import com.springboot.mongoDB.resources.util.URL;
import com.springboot.mongoDB.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) { 
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) { 
		text = URL.decodeParam(text);
		List<Post> listPost = postService.findByTitle(text);
		
		return ResponseEntity.ok().body(listPost);
	}
}	
