package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.repository.UserRepository;


@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetch data from db
		com.springboot.model.User user = userRepository.findByUsername(username);
		//checking is user is present or not in db
		if(user == null)
			throw new UsernameNotFoundException("Invalid Username");
		
		List<GrantedAuthority> list = new ArrayList<>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getDesignation());
		list.add(authority);
		
		User springUser = new User(user.getUsername(), user.getPassword(), list);
		
		return springUser;
	}

}