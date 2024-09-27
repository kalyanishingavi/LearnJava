package com.bank.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.main.model.FixedDeposit;
import com.bank.main.model.User;
import com.bank.main.model.transactionHistory;
import com.bank.main.repository.FixedDepositRepository;
import com.bank.main.repository.TransactionHistoryRepository;
import com.bank.main.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class FixedDepositController {
	
	@Autowired
	private FixedDepositRepository fixedDepositRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionHistoryRepository transactionRepository; 
	
	@PostMapping("/postFD/{uid}")
	public FixedDeposit postFD(@PathVariable("uid") Long uid , @RequestBody FixedDeposit fixedDeposit) {
		transactionHistory transaction = new transactionHistory();
		User user = userRepository.getById(uid);
		user.setAccountBalance(user.getAccountBalance()-fixedDeposit.getAmount());
		userRepository.save(user);
		fixedDeposit.setStartDate(LocalDate.now());
		fixedDeposit.setEndDate(LocalDate.from(fixedDeposit.getStartDate()).plusYears(fixedDeposit.getYears()));
		double totalAmount= fixedDeposit.getAmount()*(1+((fixedDeposit.getIntrestRate()/100)*fixedDeposit.getYears()));
		fixedDeposit.setTotalAmount(totalAmount);
		fixedDeposit.setIntrestAmount(totalAmount-fixedDeposit.getAmount());
		fixedDeposit.setUser(user);
		transaction.setDate(LocalDate.now());
		transaction.setDebit(fixedDeposit.getAmount());
		transaction.setBalance(user.getAccountBalance());
		transaction.setUser(user);
		transactionRepository.save(transaction);
		return fixedDepositRepository.save(fixedDeposit);

	}
	
	@GetMapping("/getFD/{uid}")
	public List<FixedDeposit> getFD(@PathVariable("uid") Long uid) {
		return fixedDepositRepository.findByUserId(uid);
	}
}
