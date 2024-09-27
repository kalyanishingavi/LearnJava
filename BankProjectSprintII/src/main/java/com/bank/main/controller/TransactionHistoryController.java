package com.bank.main.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.main.model.User;
import com.bank.main.model.transactionHistory;
import com.bank.main.repository.TransactionHistoryRepository;
import com.bank.main.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class TransactionHistoryController {
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("transaction/{sid}/{rid}")
	public void setTransaction(@PathVariable("sid") Long sid,
							@PathVariable("rid") Long rid,
							@RequestBody transactionHistory transaction) {
		transaction.setDate(LocalDate.now());
		User sender = userRepository.getById(sid);
		User receiver = userRepository.getById(rid);
		sender.setAccountBalance(sender.getAccountBalance()-transaction.getDebit());
		receiver.setAccountBalance(receiver.getAccountBalance() + transaction.getDebit());
		userRepository.save(sender);
		userRepository.save(receiver);
		transactionHistory temp = new transactionHistory();
		temp.setUser(sender);
		temp.setCredit(0);
		temp.setDebit(transaction.getDebit());
		temp.setBalance(sender.getAccountBalance());
		temp.setDate(LocalDate.now());
		transaction.setUser(receiver);
		transaction.setCredit(transaction.getDebit());
		transaction.setDebit(0);
		transaction.setBalance(receiver.getAccountBalance());
		List<transactionHistory> list = new ArrayList<>();
		list.add(temp);
		list.add(transaction);
		transactionHistoryRepository.saveAll(list);
		
	}
	
	@GetMapping("transaction/{uid}")
	public List<transactionHistory> setTransaction(@PathVariable("uid") Long uid) {
		return transactionHistoryRepository.findByUserId(uid);
	}
	
}
