package com.bank.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.main.model.FixedDeposit;

public interface FixedDepositRepository extends JpaRepository<FixedDeposit, Long>{

	List<FixedDeposit> findByUserId(Long uid);

}
