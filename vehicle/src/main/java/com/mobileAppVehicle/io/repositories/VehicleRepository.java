package com.mobileAppVehicle.io.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.mobileAppVehicle.io.entity.VehicleEntity;

@Repository
public interface VehicleRepository extends PagingAndSortingRepository<VehicleEntity, Long> {

	
}
