package com.lms.api.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.model.Enroll;
import com.lms.api.model.LearningTrack;
import com.lms.api.model.User;
import com.lms.api.repository.EnrollRepository;
import com.lms.api.repository.LearningTrackRepository;
import com.lms.api.repository.UserRespository;

@RestController
public class EnrollController {
	
	@Autowired
	private EnrollRepository enrollRepository;
	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private LearningTrackRepository learningTrackRepository;
	
	@PostMapping("/enroll/{uid}/{lid}")
	public Enroll enroll(@PathVariable Long uid,@PathVariable Long lid) {
		Enroll enroll = new Enroll();
		User user = userRespository.getById(uid);
		LearningTrack learningTrack = learningTrackRepository.getById(lid);
		LocalDate startdatedate = LocalDate.of(2020, 2, 21);
		LocalDate endDate = LocalDate.of(2022, 12, 31);
		enroll.setUser(user);
		enroll.setLearningTrack(learningTrack);
		enroll.setEnrollDate(startdatedate);
		enroll.setEndDate(endDate);
		return enrollRepository.save(enroll);
		
	}
}
