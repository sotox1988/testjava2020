package com.example.testjava.matias.people.service;


import com.example.testjava.matias.people.model.entity.UserEntity;

public interface IUserService {
	
	public UserEntity findByUsername(String username);
	
	public UserEntity update(UserEntity usuario);

}
