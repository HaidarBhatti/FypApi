package com.mobileAppVehicle.service;

import java.util.List;

import com.mobileAppVehicle.shared.dto.VehicleDto;

public interface VehicleService {
	
	VehicleDto createVehicle(VehicleDto vehicleDto);
	List<VehicleDto> getVehicles(int page, int limit);

}
