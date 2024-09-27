package com.bank.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.main.model.Loan;
import com.bank.main.model.User;
import com.bank.main.repository.LoanRepository;
import com.bank.main.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})

public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/loan/post/{uid}")
	public Loan postLoan(@RequestBody Loan loan,@PathVariable("uid") Long uid){
		User user = userRepository.getById(uid);
		loan.setUser(user);
		return loanRepository.save(loan);
	}
	
	@GetMapping("/loan/get/{uid}")
	public List<Loan> getLoans(@PathVariable("uid") Long uid){
		return loanRepository.findByUserId(uid);
	}
	
}
