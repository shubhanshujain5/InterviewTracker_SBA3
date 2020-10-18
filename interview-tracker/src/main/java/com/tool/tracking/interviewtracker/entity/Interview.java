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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "interviewrecord")
public class Interview {
	
	@NotNull(message="interviewId cannot be null")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "jinterview_id")
	private long interviewId;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "jinterview_id")
//	private Set<User> user=new HashSet<>();
	
	@NotNull(message="interviewerName cannot be null")
	@Column(name = "interviewerName")
	@Size(min = 5, max =30 ,message="interviewerName should be of min.5 and Max. 30 characters")
	private String interviewerName;
	
	
	@NotNull(message="interviewName cannot be null")
	@Column(name = "interviewName")
	@Size(min = 3, max =30 ,message="interviewName should be of min.3 and Max. 30 characters")
	private String interviewName;
	
	@NotNull(message="userSkills cannot be null")
	@Column(name = "userSkills")
	@Size(min = 5, max =30 ,message="userSkills should be of min.5 and Max. 30 characters")
	private String userSkills;
	
	private String date;
	
	private String time;
	
	
	@NotNull(message="interviewStatus cannot be null")
	@Column(name = "interviewStatus")
	@Size(min = 5, max =100 ,message="interviewStatus should be of min.5 and Max. 100 characters")
	private String interviewStatus;
	
	
	@NotNull(message="remarks cannot be null")
	@Column(name = "remarks")
	@Size(min = 5, max =100 ,message="remarks should be of min.5 and Max. 100 characters")
	private String remarks;
	
}