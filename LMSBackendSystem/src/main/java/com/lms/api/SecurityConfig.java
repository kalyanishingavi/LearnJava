package com.lms.api;


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

import com.lms.api.service.MyUserServiceDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Autowired
	private MyUserServiceDetails myUserServiceDetails;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthProvider());
		
		/*auth.inMemoryAuthentication()
		.withUser("harry").password(getEncodedPass().encode("potter"))
		.authorities("MANAGER")
		.and()
		.withUser("ronald").password(getEncodedPass().encode("weasely"))
		.authorities("ACCOUNTANT");*/
	}
	
	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(myUserServiceDetails);
		auth.setPasswordEncoder(getEncodedPass());
		return auth;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/user/register").permitAll()
		.antMatchers(HttpMethod.GET,"/user/login").authenticated()
		.antMatchers(HttpMethod.PUT,"/user/update").authenticated()
		.antMatchers(HttpMethod.POST,"/course/add/{lid}").permitAll()
		.antMatchers(HttpMethod.POST,"/learning-track/post").permitAll()
		.antMatchers(HttpMethod.GET,"/learning-track/course/{lid}").permitAll()
		.antMatchers(HttpMethod.GET,"/learning-track/all").permitAll()
		.antMatchers(HttpMethod.POST,"/enroll/{uid}/{lid}").permitAll()
		.antMatchers(HttpMethod.GET,"/user/learning-track/{uid}").permitAll()
		.antMatchers(HttpMethod.POST,"/author").permitAll()
		.antMatchers(HttpMethod.POST,"/course/author/**/**").permitAll()
		.antMatchers(HttpMethod.POST,"/course/author/remove/**/**").permitAll()
		.antMatchers(HttpMethod.POST,"/review/**").authenticated()
		.antMatchers(HttpMethod.GET,"/review").permitAll()
		.antMatchers(HttpMethod.GET,"/review/**").permitAll()
		.antMatchers(HttpMethod.GET,"/review/sort-rating/**").permitAll()
		.antMatchers(HttpMethod.PUT,"/review/**").authenticated()
		.antMatchers(HttpMethod.GET,"/review/get-stats-by-courseid/**").permitAll()
		.antMatchers(HttpMethod.POST,"/module/**").authenticated()
		.antMatchers(HttpMethod.POST,"/video/**").authenticated()
		.antMatchers(HttpMethod.GET,"/module/by-course/**").authenticated()
		.antMatchers(HttpMethod.GET,"/module/alternate/**").authenticated()
		.antMatchers(HttpMethod.GET,"/course/video/stats/**").permitAll()
		.antMatchers(HttpMethod.POST,"/forum").authenticated()
		.antMatchers(HttpMethod.POST,"/question").authenticated()
		.antMatchers(HttpMethod.POST,"/answer").authenticated()
		.antMatchers(HttpMethod.POST,"/forum/question/**/**").authenticated()
		.antMatchers(HttpMethod.POST,"/question/answer/**/**").authenticated()
		.antMatchers(HttpMethod.GET,"/forum/all").permitAll()
		.antMatchers(HttpMethod.GET,"/question/**").permitAll()
		.antMatchers(HttpMethod.GET,"/answer/question/**").permitAll()
		.antMatchers(HttpMethod.PUT,"/question/add-like/**").authenticated()
		.antMatchers(HttpMethod.PUT,"/answer/add-like/**").authenticated()
		.antMatchers(HttpMethod.PUT,"/answer/update/**").authenticated()
		.antMatchers(HttpMethod.PUT,"/question/update/**").authenticated()
		.antMatchers(HttpMethod.GET,"/forum/stats").permitAll()
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder getEncodedPass() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
