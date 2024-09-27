package com.springproject.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.main.beans.Customer;
import com.springproject.main.beans.Employee;
import com.springproject.main.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService ;
	
	@Autowired
	private Employee employee;	
	@RequestMapping("/customer")
	public String showCustomer(Model model){
		
		int id = 3;
		Customer customer = customerService.fetchCustomer(id);
		model.addAttribute("Csutomer", customer);
		return "customer";
	}
	
	@RequestMapping("/add-customer")
	public String addCustomer(@Valid Employee employee, BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("employee", employee);
			return "home";
		}
		model.addAttribute("employee",employee);
		return "employee";
	}
	

}
