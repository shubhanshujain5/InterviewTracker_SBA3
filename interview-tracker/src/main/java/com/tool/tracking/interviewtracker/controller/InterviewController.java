package com.tool.tracking.interviewtracker.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tool.tracking.interviewtracker.entity.Interview;
import com.tool.tracking.interviewtracker.exception.ResourceNotFoundException;
import com.tool.tracking.interviewtracker.repository.InterviewRepository;


@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
	
	@Autowired
	private InterviewRepository interviewRepository;
	
	
	
	// get all interviews
		@GetMapping
		public List<Interview> getAllInterviews() {
			return this.interviewRepository.findAll();
		}
		
		
		
		// get Interview by id
		@GetMapping("/{interviewId}")
		public Interview getInterviewById(@PathVariable (value = "interviewId") long intId) {
			return this.interviewRepository.findById(intId)
					.orElseThrow(() -> new ResourceNotFoundException("Interview not found with id :" + intId));
		}
		
		// get List of Interview by Interviewer Name
				@GetMapping("/search/{interviewerName}")
				public List<Interview> findByInterviewerName(@PathVariable (value = "interviewerName") String interviewerName) {
					return this.interviewRepository.findByInterviewerName(interviewerName);
							
				}
				
		// get List of Interview by Interview Name
				@GetMapping("/searchby/{interviewName}")
				public List<Interview> findByInterviewName(@PathVariable (value = "interviewName") String interviewName) {
					return this.interviewRepository.findByInterviewName(interviewName);
							
				}
		
	
		// create Interview
		@PostMapping
		public Interview createInterview(@Valid @RequestBody Interview interview) {
			return this.interviewRepository.save(interview);
		}
		
				
		
		// update Interview
		@PutMapping("/{interviewId}")
		public Interview updateInterview(@Valid @RequestBody Interview interview, @PathVariable ("interviewId") long intId) {
			 Interview existingInterview = this.interviewRepository.findById(intId)
				.orElseThrow(() -> new ResourceNotFoundException("Interview not found with interviewId :" + intId));
			 existingInterview.setInterviewerName(interview.getInterviewerName());
			 existingInterview.setInterviewName(interview.getInterviewName());
			 existingInterview.setUserSkills(interview.getUserSkills());
			 existingInterview.setDate(interview.getDate());
			 existingInterview.setTime(interview.getTime());
			 existingInterview.setInterviewStatus(interview.getInterviewStatus());
			 existingInterview.setRemarks(interview.getRemarks());
			 return this.interviewRepository.save(existingInterview);
		}
		
		
		// get List of Interview by Interview Status
		@GetMapping("/findby/{interviewStatus}")
		public List<Interview> findByInterviewStatus(@PathVariable (value = "interviewStatus") String interviewStatus) {
			return this.interviewRepository.findByInterviewStatus(interviewStatus);
					
		}
		
		//update interview status on the on go
		@PutMapping("/update/{interviewId}/{interviewStatus}")
		public Interview updateInterviewStatus(Interview interview, @PathVariable ("interviewId") long intId) {
			 Interview existingInterview1 = this.interviewRepository.findById(intId)
				.orElseThrow(() -> new ResourceNotFoundException("Interview not found with interviewId :" + intId));
			  existingInterview1.setInterviewStatus(interview.getInterviewStatus());
			 return this.interviewRepository.save(existingInterview1);
		}
		
		//Add an attendee to an interview
			@PostMapping("/add-attendee/{interviewId}/{id}")
			public Interview addAttendee(Interview interview, @PathVariable ("interviewId") long intId) {
				 Interview existingInterview2 = this.interviewRepository.findById(intId)
				.orElseThrow(() -> new ResourceNotFoundException("Interview not found with interviewId :" + intId));
			 existingInterview2.setInterviewStatus(interview.getInterviewStatus());
			 return this.interviewRepository.save(existingInterview2);
				}
		
			
				
			
		
		// delete Interview by id
		@DeleteMapping("/{interviewId}")
		public ResponseEntity<Interview> deleteInterview(@PathVariable ("interviewId") long intId){
			 Interview existingInterview = this.interviewRepository.findById(intId)
						.orElseThrow(() -> new ResourceNotFoundException("Interview not found with id :" + intId));
			 this.interviewRepository.delete(existingInterview);
			 return ResponseEntity.ok().build();
		}


}
