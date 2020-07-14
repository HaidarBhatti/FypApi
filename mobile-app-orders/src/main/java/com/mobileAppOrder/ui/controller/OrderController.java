package com.mobileAppOrder.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobileAppOrder.service.OrderService;
import com.mobileAppOrder.shared.dto.OrderDto;
import com.mobileAppOrder.ui.model.request.orderDetailsRequestModel;
import com.mobileAppOrder.ui.model.response.OrderRest;

@RestController
@RequestMapping("orders") // http://localhost:8080/orders
public class OrderController {

	@Autowired
	OrderService orderService;
	
	//to fetch data of all the placed orders 
	@GetMapping()
	public List<OrderRest>getOrders(@RequestParam(value = "page", defaultValue = "1")int page,
									@RequestParam(value = "limit",defaultValue = "25")int limit){
		
		List<OrderRest> returnValue=new ArrayList<>();
		
		List<OrderDto> orders=orderService.getOrders(page,limit);
		for(OrderDto OrderDto:orders) {
			OrderRest orderModel=new OrderRest();
			BeanUtils.copyProperties(OrderDto, orderModel);
			returnValue.add(orderModel);
		}
		return returnValue;
	}
	


	//for order placing
	@PostMapping
	public OrderRest createUser(@RequestBody orderDetailsRequestModel orderDetails) {
		
		OrderRest returnValue=new OrderRest();
		
		OrderDto orderDto=new OrderDto();
		BeanUtils.copyProperties(orderDetails, orderDto);
		
		OrderDto orderPlaced=orderService.placeOrder(orderDto);
		BeanUtils.copyProperties(orderPlaced, returnValue);
		
		return returnValue;
	}

	//for update order details
	@PutMapping
	public String updateUser() {
		return "order-update mapping is called";
	}

	//for deleteing orders
	@DeleteMapping
	public String deleteUser() {
		return "order-delete mapping is called";
	}
	
	


	
	
}
