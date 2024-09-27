package com.bank.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.main.model.transactionHistory;

public interface TransactionHistoryRepository extends JpaRepository<transactionHistory, Long>{

	List<transactionHistory> findByUserId(Long uid);

}
