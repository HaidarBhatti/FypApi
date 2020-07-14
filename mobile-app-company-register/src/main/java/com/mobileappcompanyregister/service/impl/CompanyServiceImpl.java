package com.mobileappcompanyregister.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mobileappcompanyregister.exceptions.UserServiceException;
import com.mobileappcompanyregister.io.entity.CompanyEntity;
import com.mobileappcompanyregister.io.repositories.CompanyRepository;
import com.mobileappcompanyregister.service.CompanyService;
import com.mobileappcompanyregister.shared.Utils;
import com.mobileappcompanyregister.shared.dto.CompanyDto;
import com.mobileappcompanyregister.ui.model.response.ErrorMessages;

@Service
public class CompanyServiceImpl implements CompanyService {

	// it implements all the functions that are mentioned in the service class

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	//to create company in the data base
	@Override
	public CompanyDto createCompany(CompanyDto company) {

		if (companyRepository.findByCompanyEmail(company.getCompanyEmail()) != null)
			throw new RuntimeException("Email already exists");
		
		// to check whether the data already exists or not (authentication)

//			else if (userRepository.findByPhoneNumber(user.getPhoneNumber()) != null)
//				throw new RuntimeException("Phone Number already exists");
//			// to check whether the data already exists or not (authentication)
//
//			else if (userRepository.findByCnicNumber(user.getCnicNumber()) != null)
//				throw new RuntimeException("CNIC number already exists");
//			// to check whether the data already exists or not (authentication)
		
		
			
//		for(int i=0;i<company.getVehicles().size();i++) {
//			
//			VehicleDto vehicle=company.getVehicles().get(i);
//			vehicle.setCompanyDetails(company);
//			vehicle.setVehicle_id(utils.generateVehicleId(30));
//			company.getVehicles().set(i,vehicle);
//			
//		}
		
 
//		CompanyEntity companyEntity=new CompanyEntity();
		
		//BeanUtils.copyProperties(company, companyEntity);
		
		ModelMapper modelMapper = new ModelMapper(); 
		CompanyEntity companyEntity=modelMapper.map(company,CompanyEntity.class);
		
		String PublicCompanyId = utils.generateUserId(30);// user id will automatically generated by this function in Utils class
		companyEntity.setCompanyId(PublicCompanyId);
		companyEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(company.getPassword()));// to encrypt user
		
		CompanyEntity storedCompanyDetails = companyRepository.save(companyEntity);

//		BeanUtils.copyProperties(storedCompanyDetails, returnValue);
		CompanyDto returnValue = modelMapper.map(storedCompanyDetails,CompanyDto.class);
		
		
		return returnValue;
	}

	
	
	@Override
	public CompanyDto getCompany(String email) {

		CompanyEntity companyEntity = companyRepository.findByCompanyEmail(email);

		if (companyEntity == null)
			throw new UsernameNotFoundException(email);

		CompanyDto returnValue = new CompanyDto();
		BeanUtils.copyProperties(companyEntity, returnValue);

		return returnValue;

	}

	// for company sign in
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		CompanyEntity companyEntity = companyRepository.findByCompanyEmail(email);

		if (companyEntity == null)
			throw new UsernameNotFoundException(email);

		return new User(companyEntity.getCompanyEmail(), companyEntity.getEncryptedPassword(), new ArrayList<>());
	}

	
	//used in getMapping method
	@Override
	public CompanyDto getCompanyByCompanyId(String companyId) {
		CompanyDto returnValue = new CompanyDto();
		CompanyEntity userEntity = companyRepository.findByCompanyId(companyId);

		if (userEntity == null) // exception handling
			throw new UsernameNotFoundException("user with ID " + companyId + " not found");
		// customized exception by using UserServiceException class and ErrorMessages
		// erum

		BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

	
	//used in putMapping method(update method)
	@Override
	public CompanyDto updateCompany(String companyId, CompanyDto company) {
		CompanyDto returnValue = new CompanyDto();
		CompanyEntity companyEntity = companyRepository.findByCompanyId(companyId);

		if (companyEntity == null)
			throw new UsernameNotFoundException(companyId);

		companyEntity.setCompanyName(company.getCompanyName());
		// here we can also implement some business logics to check whether the userDto
		// is empty or not also here we can update as many parameters as we want its
		// upto you like here I am just updating my full name parameter while I can
		// update all the parameters or a few of them just according to the need of the
		// app and the according to the need of the user

		CompanyEntity updatedCompanyDetails = companyRepository.save(companyEntity);

		BeanUtils.copyProperties(updatedCompanyDetails, returnValue);

		return returnValue;
	}
	
	
	@Override
	public void deleteCompany(String companyId) {
		CompanyEntity companyEntity =  companyRepository.findByCompanyId(companyId);
 		if (companyEntity == null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		//here we are checking that the user exist in the data base or not 
		
 		companyRepository.delete(companyEntity);

	}


//this function is used to get all the companies in the data base 
	@Override
	public List<CompanyDto> getCompanies(int page, int limit) {
		List<CompanyDto> returnValue=new ArrayList<>();
		
		if(page>0)page=page-1;
		
		Pageable pageableRequest=PageRequest.of(page, limit);
		Page<CompanyEntity> companiesPage=companyRepository.findAll(pageableRequest);
		List<CompanyEntity> companies=companiesPage.getContent();
		
		for(CompanyEntity companyEntity:companies) {
			
			CompanyDto companyDto=new CompanyDto();
			BeanUtils.copyProperties(companyEntity, companyDto);
			returnValue.add(companyDto);
			
		}
		
		return returnValue;
	}
	
	
//		@Override
//		public List<UserDto> getUsers(int page, int limit) {
//			
//			List<UserDto> returnValue=new ArrayList<>();
//			//to returnValues back to the call we have created the list or userDto
//			
//			if(page>0) {
//				page=page-1; 
//			}
//			
//			//we are doing this just for our help i mean as someHow 
//			//we just forget about the index number of the list 
//		//that starts from the 0 and we put 1 there that will cause an error
//			//for us so here we just did a litle hard coding to save our self from errors
//			
//			Pageable pageableRequest=PageRequest.of(page, limit);
//			//created this PageAble as an parameter that contains the numbers of pages and 
//			//the limit of that page and this parameter will be passed in the findAll() function
//			
//			Page<UserEntity> usersPage=userRepository.findAll(pageableRequest);
//			//we created a list like page which is of type userEntity to save the values that will return back from the userRepository()
//			
//			List<UserEntity> users=usersPage.getContent();
//			//created the list to fetch all the data that came from the userRepository() in the variable named users
//			
//			
//			//also created this loop below just to shift data from the list that is of type UserEntity into a list of type UserDto
//			for(UserEntity userEntity:users) {
//				UserDto userDto=new UserDto();
//				BeanUtils.copyProperties(userEntity, userDto);
//				returnValue.add(userDto);
//			}
//			
//			return returnValue;
//		}
//



}