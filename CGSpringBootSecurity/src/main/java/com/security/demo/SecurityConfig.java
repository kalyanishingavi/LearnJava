package com.security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.demo.service.MyUserServiceDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserServiceDetails myUserServiceDetails;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthProvider());
		
		/*auth.inMemoryAuthentication()
		.withUser("harry").password(getEncryptPassword().encode("potter"))
		.authorities("MANAGER")
		.and()
		.withUser("ronald").password(getEncryptPassword().encode("weasely"))
		.authorities("ACCOUNTANT");*/
	}
	
	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(myUserServiceDetails);
		auth.setPasswordEncoder(getPassEncoder());
		
		return auth;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
					.antMatchers(HttpMethod.POST,"/user").permitAll()
					.antMatchers("/hello/public").permitAll()
					.antMatchers("/hello").authenticated()
					.antMatchers("/hello/private").hasAnyAuthority("MANAGER")
					.anyRequest().permitAll()
					.and()
					.httpBasic()
					.and()
					.csrf().disable();
	}
	
	
	@Bean
	public PasswordEncoder getPassEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
