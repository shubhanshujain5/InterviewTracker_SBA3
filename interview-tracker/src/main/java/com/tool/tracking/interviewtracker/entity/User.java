package com.tool.tracking.interviewtracker.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
	
	@NotNull(message="id cannot be null")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinTable(name="users_interviewrecord",
//	joinColumns = {@JoinColumn(name="juser_id")},
//	inverseJoinColumns = {@JoinColumn(name="jinterview_id")})
	private long id;
	
	
//	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinTable(name="users_interviewrecord",
//	joinColumns = {@JoinColumn(name="juser_id")},
//	inverseJoinColumns = {@JoinColumn(name="jinterview_id")})
//	private Set<Interview> interview=new HashSet<>();
	
	
	@NotNull(message="firstName cannot be null")
	@Column(name = "first_name")
	@Size(min = 5, max =30 ,message="firstName should be of min. 5 and Max. 30 characters")
	private String firstName;
		

	@NotNull(message="lastName cannot be null")
	@Column(name = "last_name")
	@Size(min = 3, max =25 ,message="lastName should be of min.3 and Max. 25 characters")
	private String lastName;
	
	@Email
	@NotNull(message="email cannot be null")
	@Column(name = "email")
	private String email;
	
	
	@NotNull(message="mobile cannot be null")
	@Column(name = "mobile")
	@Size(min = 10, max =10 ,message="mobile number should be of exactly 10 numbers")
	private String mobile;
	
}
