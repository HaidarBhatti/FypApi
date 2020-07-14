package com.mobileAppOrder.service;

import java.util.List;


import com.mobileAppOrder.shared.dto.OrderDto;

public interface OrderService{

	OrderDto placeOrder(OrderDto order);
	List<OrderDto> getOrders(int page,int limit);
}
