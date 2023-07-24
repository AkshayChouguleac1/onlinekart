package com.onlineKart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Services.CustomUserDetailsService;
import com.onlineKart.jwtHelper.JwtRequest;
import com.onlineKart.jwtHelper.JwtResponse;
import com.onlineKart.jwtHelper.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/generateToken")
	public ResponseEntity<JwtResponse> getToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Username not found");
		}catch (BadCredentialsException e) {
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		//Fine area : i.e no exception occurred user is verified
		
		UserDetails userDetails= this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		
		JwtResponse jwtResponse = new JwtResponse(token);
		
		return new ResponseEntity<JwtResponse>(jwtResponse,HttpStatus.OK);
		
	}

}
