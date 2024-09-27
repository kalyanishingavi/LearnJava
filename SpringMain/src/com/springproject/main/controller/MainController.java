package com.springproject.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.main.beans.Employee;

@Controller// <-- This tells controller that this class is a controller
public class MainController{

	@Autowired
	private Employee employee;
	
	@RequestMapping("/")
	public ModelAndView showHome(Model model, HttpServletRequest request) {
		// PAssing the data to jsp
		/*
		 * Type 1: Using model Interface
		 */
		model.addAttribute("msg_model", "Hello Model");
		model.addAttribute("employee", employee);
		
		/*
		 * type 2: HTTPServletRequest class
		 */
		request.setAttribute("msg_request", "Hello Request");
		/*
		 * Type 3: ModelandView class
		 */
		ModelAndView  mav = new ModelAndView();
		mav.addObject("msg_mav", "Hello Mav");
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping("/products")
	public String showProducts(Model model, HttpServletRequest request) {
		// based on the link clicked, I will do something
		String cname = request.getParameter("name");
		model.addAttribute("cname", cname);
		return "product";
	}
	
	
}