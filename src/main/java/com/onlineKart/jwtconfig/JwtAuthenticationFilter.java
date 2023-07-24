package com.onlineKart.jwtconfig;

import java.io.IOException;



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.onlineKart.Services.CustomUserDetailsService;
import com.onlineKart.jwtHelper.JwtUtil;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
	
		//getToken
		//check Bearer
		//Validate Token
		
		String requestTokenInHeader = request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;
		String usernameFromToken=null;
		
		if(requestTokenInHeader!=null && requestTokenInHeader.startsWith("Bearer ")) {
			
			jwtToken = requestTokenInHeader.substring(7);
			
			
			try {
				usernameFromToken = this.jwtUtil.extractUsername(jwtToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//checking 
			if(usernameFromToken!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(usernameFromToken);
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("Token is not validated .. ");
			}
			
		}
		
		
		
		filterChain.doFilter(request, response);
		
		
	}

}
