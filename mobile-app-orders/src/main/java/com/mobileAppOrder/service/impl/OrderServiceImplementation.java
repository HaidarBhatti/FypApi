package com.mobileAppOrder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mobileAppOrder.io.entity.OrderEntity;
import com.mobileAppOrder.io.repositories.OrderRepository;
import com.mobileAppOrder.service.OrderService;
import com.mobileAppOrder.shared.Utils;
import com.mobileAppOrder.shared.dto.OrderDto;


@Service
public class OrderServiceImplementation implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	Utils utils;

	@Override
	public OrderDto placeOrder(OrderDto order) {

		// to check whether the phone number already exist or not for exception
		if (orderRepository.findByPhoneNumber(order.getPhoneNumber()) != null)
			throw new RuntimeException(" Phone Number already exist ");

		OrderDto returnValue = new OrderDto();

		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(order, orderEntity);
		
		String OrderId=utils.generateOrderId(30);

		orderEntity.setOrderStatus("pending");
		orderEntity.setOrderId(OrderId);

		OrderEntity savedOrderDetails = orderRepository.save(orderEntity);
		BeanUtils.copyProperties(savedOrderDetails, returnValue);

		return returnValue;
	}

	
	@Override
	public List<OrderDto> getOrders(int page, int limit) {
		List<OrderDto> returnValue=new ArrayList<>();
		Pageable pagealeRequest=PageRequest.of(page,limit);
		

		Page<OrderEntity> ordersPage=orderRepository.findAll(pagealeRequest);
		List<OrderEntity> orders=ordersPage.getContent();
		
		for(OrderEntity orderEntity:orders) {
			OrderDto orderDto=new OrderDto();
			BeanUtils.copyProperties(orderEntity, orderDto);
			returnValue.add(orderDto);
		}
		
		return returnValue;
	}

}
