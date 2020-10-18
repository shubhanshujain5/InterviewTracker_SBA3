package com.tool.tracking.interviewtracker.controller;

import java.util.List;
import javax.validation.Valid;
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

import com.tool.tracking.interviewtracker.dto.UserDto;
import com.tool.tracking.interviewtracker.entity.User;
import com.tool.tracking.interviewtracker.exception.ResourceNotFoundException;
import com.tool.tracking.interviewtracker.repository.UserRepository;
import com.tool.tracking.interviewtracker.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

	//below line removed just now
//	@Autowired
//	private UserRepository userRepository;
	
	//below line is newly added
	@ Autowired
	UserService service;

	// get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users=this.service.getAllUsers();
		
		ResponseEntity<List<User>> response = 
				new ResponseEntity<List<User>>(users, HttpStatus.OK);
		return response;
	}
	

	// get user by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable (value = "id") long userId) {
		User user=this.service.getUserById(userId);
			
		
		ResponseEntity <User> response = 
				new ResponseEntity <User>(user, HttpStatus.OK);
		return response;
	}

	// create user
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User addedStudent=this.service.createUser(user);
		
		ResponseEntity<User> response = 
				new ResponseEntity<User>(addedStudent, HttpStatus.OK);
		return response;
	}
	
	// update user
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable ("id") long userId) {
		User updateUser = this.service.updateUser(user, userId);
		ResponseEntity<User> response = 
				new ResponseEntity<User>(updateUser, HttpStatus.OK);
		return response;
	}
	
	
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		 ResponseEntity<User> user = this.service.deleteUser(userId);
				
		 
		 ResponseEntity<User> response = 
					new ResponseEntity<User>(HttpStatus.OK);
			return response;
	}
	
	
}
