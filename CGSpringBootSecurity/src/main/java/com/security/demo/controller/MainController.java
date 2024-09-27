package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.User;
import com.security.demo.repository.UserRepository;

@RestController
public class MainController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello User";
	}
	
	@GetMapping("/hello/public")
	public String sayHelloPublic() {
		return "Hello Public";
	}
	
	@GetMapping("/hello/private")
	public String sayHelloPrivate() {
		return "Hello Private";
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
		String encodedpassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedpassword);
		return userRepository.save(user);
		
	}
}
