package com.sl.ms.ordermanagement.bll;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sl.ms.ordermanagement.dto.Order;

@Component
public interface IOrderSummaryReport {
	
	List<Order> getAllData();

	Order read(String orderId);

	String acceptOrder(String orderId, Order order);

	boolean deleteOrder(String orderId);

	String insertOrder(String orderId, Order order);

}
