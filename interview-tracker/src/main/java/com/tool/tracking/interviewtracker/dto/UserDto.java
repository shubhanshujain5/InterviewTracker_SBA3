package com.tool.tracking.interviewtracker.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {
	
	
	@NotNull(message="id cannot be null")
	private long id;
	
	@NotNull(message="firstName cannot be null")
	@Size(min = 5, max =30 ,message="firstName should be of min. 5 and Max. 30 characters")
	private String firstName;
	
	@NotNull(message="lastName cannot be null")
	@Size(min = 3, max =25 ,message="lastName should be of min.3 and Max. 25 characters")
	private String lastName;
	
	@Email
	@NotNull(message="email cannot be null")
	private String email;
	
	@NotNull(message="mobile cannot be null")
	@Size(min = 10, max =10 ,message="mobile number should be of exactly 10 numbers")
	private String mobile;

}
