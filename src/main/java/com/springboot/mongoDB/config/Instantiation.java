package com.springboot.mongoDB.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springboot.mongoDB.domain.entities.User;
import com.springboot.mongoDB.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User user1 = new User(null, "Luis", "luis@gamil.com");		
		User user2 = new User(null, "Pedro", "pedro@gamil.com");		
		User user3 = new User(null, "Tiago", "tiago@gamil.com");		
		User user4 = new User(null, "Ana", "ana@gamil.com");	
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
	}
	
}
