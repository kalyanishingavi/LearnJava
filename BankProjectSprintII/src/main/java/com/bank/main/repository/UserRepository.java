package com.bank.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.main.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	

}
