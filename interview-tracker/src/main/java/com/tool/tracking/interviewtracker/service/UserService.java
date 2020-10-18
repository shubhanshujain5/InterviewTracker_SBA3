package com.tool.tracking.interviewtracker.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tool.tracking.interviewtracker.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public User getUserById(long userId);
	public User createUser(User user);
	public User updateUser(User user,long userId);
	public ResponseEntity<User> deleteUser(long userId);

}
