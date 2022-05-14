package com.devsuperior.dslearn.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.dslearn.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		var user = this.userRepository.findByEmail(username);
		
		if (user == null) {
			LOGGER.error("User not found. Email: " + username);
			throw new UsernameNotFoundException("User not found. Email: " + username);
		}
		
		LOGGER.info("User found. Email: " + user.getEmail());
		return user;
	}
	
}
