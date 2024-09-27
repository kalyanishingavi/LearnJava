package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	/*
	 * getMapping makes this api a get Api
	 */
	@GetMapping("/hello")
	public String helloWorldApi() {
		return "hello Boot";
	}
	
	
}
