package com.bank.main.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.main.model.User;
import com.bank.main.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class UserController {

	@Autowired
	UserRepository userRepository;
		
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/post/user")
	public User postUser(@RequestBody User user) {
		user.setPassword1(user.getPassword());
		String encodedpassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedpassword);
		return userRepository.save(user);
	}
	
	@GetMapping("/user")
	public List<User> getUser() {
		List<User> user = userRepository.findAll();
		return user;
	}

	public PasswordEncoder getPassEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@PutMapping("/update/user/{uid}")
	public User updateUser(@PathVariable("uid") Long uid,@RequestBody User user) {
		User dbUser = userRepository.getById(uid);
		if(user.getMobileNumber()!=null && user.getMobileNumber()!="")
			dbUser.setMobileNumber(user.getMobileNumber());
		if(user.getEmailId()!=null && user.getEmailId()!="")
			dbUser.setEmailId(user.getEmailId());
		return userRepository.save(dbUser);
	}
	
}
