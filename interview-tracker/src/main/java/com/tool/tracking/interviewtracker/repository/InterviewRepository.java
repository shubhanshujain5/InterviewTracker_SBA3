package com.tool.tracking.interviewtracker.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tool.tracking.interviewtracker.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{
	
	List <Interview> findByInterviewerName(String interviewerName);
	List <Interview> findByInterviewName(String interviewName);
	List <Interview> findByInterviewStatus(String interviewStatus);
	
	

}

 

