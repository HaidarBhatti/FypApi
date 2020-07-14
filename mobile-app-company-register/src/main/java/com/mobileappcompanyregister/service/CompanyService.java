package com.mobileappcompanyregister.service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mobileappcompanyregister.shared.dto.CompanyDto;

public interface CompanyService extends UserDetailsService{
	
	CompanyDto createCompany(CompanyDto company);
	CompanyDto getCompany(String email);
	CompanyDto getCompanyByCompanyId(String companyId);
	CompanyDto updateCompany(String companyId, CompanyDto company);
	void deleteCompany(String companyId);
	List<CompanyDto> getCompanies(int page, int limit);
	
	
	
	
	
	
	
	//all the functions mentioned in this interface are implemented in UserServiceImpl class
	
//		UserDto createUser(UserDto user);//this function will create database and save data in the database
	
//		UserDto getUser(String email);
//		UserDto getUserByUserId(String userId);
//		UserDto updateUser(String userId, UserDto user);
//		void deleteUser(String userId);
//		List<UserDto> getUsers(int page,int limit);

}
