package com.example.testjava.matias.people.security.event;

import com.example.testjava.matias.people.model.entity.UserEntity;
import com.example.testjava.matias.people.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	private Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

	@Autowired
	private IUserService userService;

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String mensaje = "Success Login: " + user.getUsername();
		log.info(mensaje);
		
		UserEntity userEntity = userService.findByUsername(user.getUsername());
		
		if(userEntity.getTries() != null && userEntity.getTries() > 0) {
			userEntity.setTries(0);
			userService.update(userEntity);
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String msj = "Login error: " + exception.getMessage();
		log.error(msj);
		System.out.println(msj);

		try {
			
			StringBuilder errors = new StringBuilder();
			errors.append(msj);
			
			UserEntity userEntity = userService.findByUsername(authentication.getName());
			if (userEntity.getTries() == null) {
				userEntity.setTries(0);
			}
			
			log.info("Current attempts is: " + userEntity.getTries());

			userEntity.setTries(userEntity.getTries()+1);
			
			log.info("Attempts after is: " + userEntity.getTries());
			
			errors.append(" - Login attempts: " + userEntity.getTries());
			
			userService.update(userEntity);
			
		} catch (Exception e) {
			log.error(String.format("User %s does not exist in the system", authentication.getName()));
		}

	}

}
