package com.bank.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.main.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

	List<Loan> findByUserId(Long uid);

}
