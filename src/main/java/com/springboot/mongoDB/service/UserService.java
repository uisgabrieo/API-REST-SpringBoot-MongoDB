package com.springboot.mongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongoDB.domain.entities.User;
import com.springboot.mongoDB.dto.UserDTO;
import com.springboot.mongoDB.repository.UserRepository;
import com.springboot.mongoDB.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	public User update(String id, User obj) {
		User user = findById(id);
		update(user, obj);
		return userRepository.save(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	private static User update(User user, User obj) {
		if (obj.getName() != null) {
			user.setName(obj.getName());
		}
		if (obj.getEmail() != null) {
			user.setEmail(obj.getEmail());
		}
		
		return user;
		
	}
}
