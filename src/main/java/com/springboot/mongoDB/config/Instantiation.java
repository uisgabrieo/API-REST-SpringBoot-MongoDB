package com.springboot.mongoDB.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springboot.mongoDB.domain.entities.Post;
import com.springboot.mongoDB.domain.entities.User;
import com.springboot.mongoDB.dto.AuthorDTO;
import com.springboot.mongoDB.dto.CommentDTO;
import com.springboot.mongoDB.repository.PostRepository;
import com.springboot.mongoDB.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User user1 = new User(null, "Luis", "luis@gamil.com");		
		User user2 = new User(null, "Pedro", "pedro@gamil.com");		
		User user3 = new User(null, "Tiago", "tiago@gamil.com");		
		User user4 = new User(null, "Ana", "ana@gamil.com");	
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
		
		Post post1 = new Post(null, 
				LocalDate.parse("21/03/2018", fmt), 
				"Partiu viagem", 
				"Vou viajar. Bj", 
				new AuthorDTO(user1));
		Post post2 = new Post(null, 
				LocalDate.parse("03/07/2004", fmt), 
				"Bom dia!", 
				"Acordei.", 
				new AuthorDTO(user1));
		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", 
				LocalDate.parse("21/03/2018", fmt), 
				new AuthorDTO(user2));
		
		CommentDTO comment2 = new CommentDTO("Aproveite!", 
				LocalDate.parse("22/03/2018", fmt), 
				new AuthorDTO(user3));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", 
				LocalDate.parse("23/03/2018", fmt), 
				new AuthorDTO(user2));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		user1.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(user1);
		
	}
	
}
