package com.springboot.mongoDB.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongoDB.domain.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria", "maria@gmail.com");
		User luis = new User("2", "Luis", "luis@gmail.com");
		User pedro = new User("3", "Pedro", "pedro@gmail.com");
		List<User> list = (Arrays.asList(maria, luis, pedro));
		
		return ResponseEntity.ok().body(list);
	}
}
