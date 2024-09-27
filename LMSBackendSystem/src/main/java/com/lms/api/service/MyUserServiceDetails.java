package com.lms.api.service;

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

import com.lms.api.repository.UserRespository;


@Service
public class MyUserServiceDetails implements UserDetailsService{

	@Autowired
	private UserRespository userRespository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * First go to db and check wheter the username is present or not
		 * If present fetch the deatils
		 * If not present then throw  UsernameNotFoundException
		 */
		
		com.lms.api.model.User user = userRespository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("Invalid Username");
		
		/*
		 * convert role to authority as spring user dosent accept string values it needs 
		 * list of authority as a parameter
		 */
		List<GrantedAuthority> list = new ArrayList<>();
		String role = user.getRole();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		list.add(authority);
		
		/*
		 * Adding username password and list of grantedauthorities details of database to spring internal user
		 */
		User springUser = new User(user.getUsername(),user.getPass(),list);
		return springUser;
	}

}
