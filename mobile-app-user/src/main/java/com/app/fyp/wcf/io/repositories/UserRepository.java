package com.app.fyp.wcf.io.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.fyp.wcf.io.entity.UserEntity;

@Repository

//first we did extended the parent file named as CrudRepository() but then for 
//paging and sorting purposes we replaced the parent class of 
//CrudRepository() with PagingAndSortingRepository()

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	UserEntity findByPhoneNumber(String phoneNumber);
	UserEntity findByCnicNumber(String cnic);
	//UserEntity findUserByEmail(String email);
	
	UserEntity findByUserId(String userId);
	
}
