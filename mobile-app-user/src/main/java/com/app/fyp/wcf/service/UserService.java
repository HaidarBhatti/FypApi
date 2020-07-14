package com.app.fyp.wcf.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.fyp.wcf.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	//all the functions mentioned in this interface are implemented in UserServiceImpl class
	
	UserDto createUser(UserDto user);//this function will create database and save data in the database
	UserDto getUser(String email);
	UserDto getUserByUserId(String userId);
	UserDto updateUser(String userId, UserDto user);
	void deleteUser(String userId);
	List<UserDto> getUsers(int page,int limit);
}
