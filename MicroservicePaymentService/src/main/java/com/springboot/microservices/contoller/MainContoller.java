package com.springboot.microservices.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainContoller {

	@GetMapping("/hello")
	public String helloApi() {
		return "hello from payment service";
	}
}
