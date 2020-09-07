package com.example.testjava.matias.people.service.impl;

import com.example.testjava.matias.people.model.entity.UserEntity;
import com.example.testjava.matias.people.repository.OAuthRepository;
import com.example.testjava.matias.people.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService, UserDetailsService {

	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private OAuthRepository oAuthRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			UserEntity userEntity = oAuthRepository.findByUsername(username);

			List<GrantedAuthority> authorities =
					userEntity.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName()))
					.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

			log.info("User authenticated: " + username);

			return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEnabled(), true, true, true,
					authorities);

		} catch (Exception e) {
			String error = "Login failed, user does not exist '" + username + "' in the system";
			log.error(error);

			throw new UsernameNotFoundException(error);
		}
	}

	@Override
	public UserEntity findByUsername(String username) {
		return oAuthRepository.findByUsername(username);
	}

	@Override
	public UserEntity update(UserEntity usuario) {
		return oAuthRepository.save(usuario);
	}

}
