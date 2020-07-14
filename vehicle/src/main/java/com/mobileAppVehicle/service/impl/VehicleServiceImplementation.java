package com.mobileAppVehicle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mobileAppVehicle.io.entity.VehicleEntity;
import com.mobileAppVehicle.io.repositories.VehicleRepository;
import com.mobileAppVehicle.service.VehicleService;
import com.mobileAppVehicle.shared.dto.VehicleDto;

@Service
public class VehicleServiceImplementation implements VehicleService{

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public VehicleDto createVehicle(VehicleDto vehicleDto) {
		
		VehicleDto returnValue=new VehicleDto();
		
		VehicleEntity vehicleEntity=new VehicleEntity();
		BeanUtils.copyProperties(vehicleDto, vehicleEntity);
		
		vehicleEntity.setVehicleId("vehicle id");
		
		VehicleEntity storedVehiclesDetails=vehicleRepository.save(vehicleEntity);
		BeanUtils.copyProperties(storedVehiclesDetails, returnValue);
		
		return returnValue;
	
	}

	@Override
	public List<VehicleDto> getVehicles(int page, int limit) {
		List<VehicleDto> returnValue=new ArrayList<>();
		
		Pageable pagealeRequest=PageRequest.of(page,limit);
		

		Page<VehicleEntity> vehiclesPage=vehicleRepository.findAll(pagealeRequest);
		List<VehicleEntity> vehicle=vehiclesPage.getContent();
		
		for(VehicleEntity vehicleEntity:vehicle) {
			VehicleDto vehicleDto=new VehicleDto();
			BeanUtils.copyProperties(vehicleEntity, vehicleDto);
			returnValue.add(vehicleDto);
		}
		
		return returnValue;
	}

	
}
