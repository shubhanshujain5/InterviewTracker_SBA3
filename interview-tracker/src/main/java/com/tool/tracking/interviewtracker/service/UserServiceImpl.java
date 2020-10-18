package com.tool.tracking.interviewtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tool.tracking.interviewtracker.entity.User;
import com.tool.tracking.interviewtracker.exception.ResourceNotFoundException;
import com.tool.tracking.interviewtracker.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	}

	@Override
	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User updateUser(User user, long userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
			 existingUser.setFirstName(user.getFirstName());
			 existingUser.setLastName(user.getLastName());
			 existingUser.setEmail(user.getEmail());
			 existingUser.setMobile(user.getMobile());
			 return this.userRepository.save(existingUser);
	}

	@Override
	public ResponseEntity<User> deleteUser(long userId) {
		 User existingUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}

}
