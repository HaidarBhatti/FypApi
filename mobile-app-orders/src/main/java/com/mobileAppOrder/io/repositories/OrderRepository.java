package com.mobileAppOrder.io.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mobileAppOrder.io.entity.OrderEntity;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long>{

	OrderEntity findByPhoneNumber(String phoneNumber);
	
}
