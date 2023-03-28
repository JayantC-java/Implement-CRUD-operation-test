package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/users")
	public String createNewUser(@RequestBody User user) {
		userRepository.save(user);
		return "User created in the database";
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		Optional<User> us= userRepository.findById(id);
		if(us.isPresent()) {
			return new ResponseEntity<User>(us.get(), HttpStatus.FOUND);
		}else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/users/{id}")
	public String updateUserById(@PathVariable Long id, @RequestBody User user) {
		Optional<User> us = userRepository.findById(id);
		if(us.isPresent()) {
			User existUser = us.get();
			existUser.setFirst_name(user.getFirst_name());
			existUser.setLast_name(user.getLast_name());
			existUser.setEmail(user.getEmail());
			existUser.setAge(user.getAge());
			userRepository.save(existUser);
			return "User details against id " + id + " updated";
		}else {
			return "User details does not exist for this id " + id;
		}
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "User details deleted successfully";
	}
	
	@DeleteMapping("/users")
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "All Users data deleted successfully";
	}

}
