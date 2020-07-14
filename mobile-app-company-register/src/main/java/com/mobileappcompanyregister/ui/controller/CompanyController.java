package com.mobileappcompanyregister.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobileappcompanyregister.exceptions.UserServiceException;
import com.mobileappcompanyregister.service.CompanyService;
import com.mobileappcompanyregister.shared.dto.CompanyDto;
import com.mobileappcompanyregister.ui.model.request.CompanyDetailsRequestModel;
import com.mobileappcompanyregister.ui.model.response.CompanyRest;
import com.mobileappcompanyregister.ui.model.response.ErrorMessages;
import com.mobileappcompanyregister.ui.model.response.OperationStatusModel;
import com.mobileappcompanyregister.ui.model.response.RequestOperationName;
import com.mobileappcompanyregister.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("company") // http://localhost:8080/company
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CompanyRest getUser(@PathVariable String id) {

		CompanyRest returnValue = new CompanyRest();

		CompanyDto companyDto = companyService.getCompanyByCompanyId(id);
		BeanUtils.copyProperties(companyDto, returnValue);

		return returnValue;
	}

	//for user sign_up purpose and for the all vehicles record
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
				 produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	
	public CompanyRest createCompany(@RequestBody CompanyDetailsRequestModel companyDetailsRequestModel)throws Exception
	{
		CompanyRest returnValue = new CompanyRest();// object to get return value

		if (companyDetailsRequestModel.getCompanyName().isEmpty())
			throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		// NullPointerException("the object is null");

//		CompanyDto companyDto = new CompanyDto();// dto object
//		BeanUtils.copyProperties(companyDetailsRequestModel, companyDto);
		
		ModelMapper modelMapper = new ModelMapper();
		CompanyDto companyDto = modelMapper.map(companyDetailsRequestModel, CompanyDto.class);

		CompanyDto createdCompany = companyService.createCompany(companyDto);
		returnValue=modelMapper.map(createdCompany,CompanyRest.class);

		return returnValue;
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })

	public CompanyRest updateUser(@PathVariable String id, @RequestBody CompanyDetailsRequestModel companyDetailsRequestModel) {

		CompanyRest returnValue = new CompanyRest();// object to get return value

		//if (userDetails.getFullName().isEmpty())// here i am just checking the one parameter that whether it is empty or
												// not while we can check as many as we want according to the need
		//	throw new NullPointerException("the object is null");

		CompanyDto userDto = new CompanyDto();// dto object
		BeanUtils.copyProperties(companyDetailsRequestModel, userDto);

		CompanyDto updatedCompany = companyService.updateCompany(id, userDto);
		BeanUtils.copyProperties(updatedCompany, returnValue);

		return returnValue;

	}

	@DeleteMapping(path = "/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteUser(@PathVariable String id) {

		OperationStatusModel returnValue = new OperationStatusModel();
		
		
		companyService.deleteCompany(id);
		
		
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}
	
	
	//this function is used to get all the registered companies in the data base
	//all companies that are applied or have signup
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CompanyRest> getCompanies(@RequestParam(value = "page",defaultValue = "0")int page,
			@RequestParam(value = "limit",defaultValue = "10")int limit)
	{
	
		List<CompanyRest> returnValue=new ArrayList<>();
		
		List<CompanyDto> companies=companyService.getCompanies(page,limit);
		
		for(CompanyDto companyDto:companies) {
			
			CompanyRest companyModel=new CompanyRest();
			BeanUtils.copyProperties(companyDto, companyModel);
			returnValue.add(companyModel);
		}
		
		return returnValue;
		
	}
}
