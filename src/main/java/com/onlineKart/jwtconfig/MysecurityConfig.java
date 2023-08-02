package com.onlineKart.jwtconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.onlineKart.Services.CustomUserDetailsService;
@Configuration
@EnableWebSecurity
public class MysecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
@Bean
public PasswordEncoder passwordEncoder()
{
	return NoOpPasswordEncoder.getInstance();
}
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
}
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(customUserDetailsService);

}
@Override
protected void configure(HttpSecurity http) throws Exception {
	http
    .csrf()
    .disable()
    .cors()
    .disable()
    .authorizeRequests()
    .antMatchers("/generateToken").permitAll()
    .antMatchers("/refreshToken").permitAll()
    .antMatchers("/api/v1/users/signup").permitAll()
    .antMatchers("/api/v1/addresses/addAddress").permitAll()
    .antMatchers("/signup/customer/add").permitAll() 
    .antMatchers("/refreshToken").permitAll()
    .antMatchers(HttpMethod.OPTIONS).permitAll()
    .anyRequest().authenticated()
    .and()
    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
    .exceptionHandling().authenticationEntryPoint(entryPoint);
http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
}














}
