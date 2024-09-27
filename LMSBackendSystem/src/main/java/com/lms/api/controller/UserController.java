package com.lms.api.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.UserDto;
import com.lms.api.dto.UserLearningTrackDto;
import com.lms.api.model.LearningTrack;
import com.lms.api.model.User;
import com.lms.api.repository.EnrollRepository;
import com.lms.api.repository.UserRespository;

@RestController
public class UserController {

	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private EnrollRepository enrollRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/user/register")
	public User register(@RequestBody User user) {
		String plainText = user.getPass();
		String encodedPass = passwordEncoder.encode(plainText);
		user.setPass(encodedPass);
		userRespository.save(user);
		return user;

	}
	
	@GetMapping("/user/login")
	public UserDto login(Principal principal) {
		String username = principal.getName();
		User user = userRespository.findByUsername(username);
		UserDto dto = new UserDto();
		dto = dto.convert(user);
		return dto;
	}
	
	@PutMapping("/user/update")
	public UserDto updateUser(Principal principal,@RequestBody User userNew) {
		 User user =userRespository.findByUsername(principal.getName());
		if(userNew.getName()!=null)	
			user.setName(userNew.getName());
		if(userNew.getMobileNo()!=null)
			user.setMobileNo(userNew.getMobileNo());
		if(userNew.getCity()!=null)
			user.setCity(userNew.getCity());
		
		userRespository.save(user);
		UserDto dto = new UserDto();
		dto = dto.convert(user);
		return dto;
	}
	
	@GetMapping("/user/learning-track/{uid}")
	public UserLearningTrackDto getAllLearningTrackByUserId(@PathVariable Long uid) {
		User user= userRespository.getById(uid);
		List<LearningTrack> list = enrollRepository.findBylearningtrackid(uid);
		UserLearningTrackDto dto = new UserLearningTrackDto();
		dto.setUser(user);
		dto.setList(list);
		return dto;
		
	}
	
}
