package com.collegesearch.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.collegesearch.domain.user.User;
import com.collegesearch.service.user.UserService;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired UserService userService;	
	Collection<? extends GrantedAuthority> grantedAuthorities = new ArrayList<>();
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	   UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
	   String userName = token.getName();
	   User user = null;
	   //1. Use the username to load the data for the user, including authorities and password. 
	   if(userName != null && !userName.isEmpty())
		  user = userService.getUserByName(userName); //rethrow exceptions if they occur
	   if(user == null) {
	     throw new UsernameNotFoundException("User not found for the given username: " + userName);
	   }
	   String password = user.getPassword();
	   // 2. Check the passwords match.
	   if(!password.equals(token.getCredentials())) {
	      throw new BadCredentialsException("Invalid username/password");
	   }
	   Collection<? extends GrantedAuthority> grantedAuthorities = user.getAuthorities();
	   // 3. Preferably clear the password in the user object before storing in authentication object
	   user.clearPassword();
	   // 4. Return an authenticated token, containing user data and authorities 
	   //grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	   Authentication auth = new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
	   SecurityContextHolder.getContext().setAuthentication(auth);
	   return auth;
	}
	
	public boolean supports(Class<?> authentication) {
	   return UsernamePasswordAuthenticationToken.class.equals(authentication); 
	}
}
