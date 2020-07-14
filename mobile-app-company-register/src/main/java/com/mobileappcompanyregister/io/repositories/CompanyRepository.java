package com.mobileappcompanyregister.io.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mobileappcompanyregister.io.entity.CompanyEntity;


@Repository

//first we did extended the parent file named as CrudRepository() but then for 
//paging and sorting purposes we replaced the parent class of 
//CrudRepository() with PagingAndSortingRepository()

//PagingAndSortingRepository

public interface CompanyRepository extends PagingAndSortingRepository<CompanyEntity,Long>{
		
	CompanyEntity findByCompanyEmail(String email);
	CompanyEntity findByCompanyId(String userId);
}
