package com.mobileAppVehicle.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobileAppVehicle.service.VehicleService;
import com.mobileAppVehicle.shared.dto.VehicleDto;
import com.mobileAppVehicle.ui.mode.request.VehiclesDetailsRequestModel;
import com.mobileAppVehicle.ui.mode.response.VehicleRest;

@RestController
@RequestMapping("vehicles")// http://localhost:8080/vehicles
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	//to post all the record of the vehicles in the database
	@PostMapping
	public VehicleRest createVehicles(@RequestBody VehiclesDetailsRequestModel vehiclesDetails) {
		VehicleRest returnValue=new VehicleRest();
		
		VehicleDto vehicleDto=new VehicleDto();
		BeanUtils.copyProperties(vehiclesDetails, vehicleDto);
		
		VehicleDto createdVehicle=vehicleService.createVehicle(vehicleDto);
		BeanUtils.copyProperties(createdVehicle, returnValue);
		
		return returnValue;
	}
	
	@GetMapping()
	public List<VehicleRest>getOrders(@RequestParam(value = "page", defaultValue = "1")int page,
									@RequestParam(value = "limit",defaultValue = "25")int limit){
		
		List<VehicleRest> returnValue=new ArrayList<>();
		
		List<VehicleDto> vehicle=vehicleService.getVehicles(page,limit);
		
		for(VehicleDto vehicleDto:vehicle) {
			VehicleRest vehicleModel=new VehicleRest();
			BeanUtils.copyProperties(vehicleDto, vehicleModel);
			returnValue.add(vehicleModel);
		}
		return returnValue;
	}

}
