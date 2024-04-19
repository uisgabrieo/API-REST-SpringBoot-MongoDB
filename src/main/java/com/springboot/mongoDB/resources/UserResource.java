package com.springboot.mongoDB.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongoDB.domain.entities.User;
import com.springboot.mongoDB.dto.UserDTO;
import com.springboot.mongoDB.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> userDto = list.stream().map(x -> new UserDTO(x)).toList();
		return ResponseEntity.ok().body(userDto);
	}
}
