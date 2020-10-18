package com.tool.tracking.interviewtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tool.tracking.interviewtracker.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
