package com.lms.api.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.model.Answer;
import com.lms.api.repository.AnswerRepository;

@RestController
public class AnswerController {

	@Autowired
	private AnswerRepository answerRepository;
	/*
	 * post API for question
	 */
	@PostMapping("/answer")
	public Answer postAnswer(@RequestBody Answer answer, Principal principal) {
		answer.setUsername(principal.getName());	// get username by principal interface
		answer.setDateOfPost(LocalDate.of(2022, 03, 10));
		return answerRepository.save(answer);		// save to db
	}
	

	@PutMapping("/answer/add-like/{aid}")
	public Answer putALike(@PathVariable("aid") Long aid) {
		Answer answer = answerRepository.getById(aid);	// get answer by answer id
		answer.setLikes(answer.getLikes() + 1); 		// add 1 like to previous likes
		return answerRepository.save(answer);		// save to db
	}
	
	@PutMapping("/answer/update/{aid}")
	public Answer updateAnswer(@RequestBody Answer answer, 
								@PathVariable("aid") Long aid,
								Principal principal) {
		String user = principal.getName();		// get username by principal
		Answer answerDB = answerRepository.getById(aid);	// get answer from db 
		/*
		 * throw exception is the another user is trying to update the answer
		 */
		if(! user.equalsIgnoreCase(answerDB.getUsername()))
			throw new RuntimeException("User not allowed to update the answer");
		/*
		 * update if user has enterd the updated answer
		 */
		if(answer.getAnswerText() != null) {
			answerDB.setAnswerText(answer.getAnswerText());
			/*
			 * set the new date after update
			 */
			answerDB.setDateOfPost(LocalDate.now());
		}
		return answerRepository.save(answerDB);	// save to db
	}
}
