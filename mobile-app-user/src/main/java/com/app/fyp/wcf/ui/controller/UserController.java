package com.app.fyp.wcf.ui.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.app.fyp.wcf.exception.UserServiceException;
import com.app.fyp.wcf.service.UserService;
import com.app.fyp.wcf.shared.dto.UserDto;
import com.app.fyp.wcf.ui.model.request.UserDetailsRequestmodel;
import com.app.fyp.wcf.ui.model.response.ErrorMessages;
import com.app.fyp.wcf.ui.model.response.OperationStatusModel;
import com.app.fyp.wcf.ui.model.response.RequestOperationName;
import com.app.fyp.wcf.ui.model.response.RequestOperationStatus;
import com.app.fyp.wcf.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost/8080/users
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest getUser(@PathVariable String id) {

		UserRest returnValue = new UserRest();

		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);

		return returnValue;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public UserRest createUser(@RequestBody UserDetailsRequestmodel userDetails) throws Exception

	{
		UserRest returnValue = new UserRest();// object to get return value

		if (userDetails.getFullName().isEmpty())
			throw new NullPointerException("the object is null");

		UserDto userDto = new UserDto();// dto object
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })

	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestmodel userDetails) {

		UserRest returnValue = new UserRest();// object to get return value

		//if (userDetails.getFullName().isEmpty())// here i am just checking the one parameter that whether it is empty or
												// not while we can check as many as we want according to the need
		//	throw new NullPointerException("the object is null");

		UserDto userDto = new UserDto();// dto object
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto updatedUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updatedUser, returnValue);

		return returnValue;

	}

	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteUser(@PathVariable String id) {

		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());

		userService.deleteUser(id);

		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

	@GetMapping(produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	
	public List<UserRest> getUsers(@RequestParam (value="page", defaultValue="0")
	int page,@RequestParam (value="limit", defaultValue="25")int limit)
	{
		
		List<UserRest> returnValue=new ArrayList<>();
		
		List<UserDto> users=userService.getUsers(page,limit);
		
		for(UserDto userDto:users) {
			
			UserRest userModel=new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			returnValue.add(userModel);
			
		}
		
		return returnValue;
	}
	
}
