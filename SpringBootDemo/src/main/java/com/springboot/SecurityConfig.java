package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
				.withUser("harry").password(getEncodedPassword().encode("potter"))
				.authorities("MANAGER")
				.and()
				.withUser("ronald").password(getEncodedPassword().encode("weasley"))
				.authorities("EMPLOYEE");
				*/
		auth.authenticationProvider(getAuthProvider());	
	}
	
	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(getEncodedPassword());
		
		return auth;

		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/employee").hasAuthority("MANAGER")
			.antMatchers("/employee/{id}").authenticated()
			.antMatchers("/employee/city").authenticated()
			.antMatchers("/employee/salary").authenticated()
			.antMatchers("/employee/age").authenticated()
			.antMatchers("/employee/deparment/{did}").authenticated()
			.antMatchers("/department").permitAll()
			.antMatchers("/project").hasAuthority("MANAGER")
			.antMatchers("/project/{pid}").authenticated()
			.antMatchers("/employeeproject").authenticated()
			.antMatchers("/employee/project/{pid}").authenticated()
			.anyRequest().permitAll()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder getEncodedPassword() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
