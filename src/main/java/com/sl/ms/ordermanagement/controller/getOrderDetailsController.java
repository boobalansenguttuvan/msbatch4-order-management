package com.sl.ms.ordermanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ms.ordermanagement.bll.IOrderSummaryReport;
import com.sl.ms.ordermanagement.dto.Order;
import com.sl.ms.ordermanagement.exception.OrderNotfoundException;

@RestController
public class getOrderDetailsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IOrderSummaryReport orderSummary;

	@RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)

	public ResponseEntity<Order> getOrderDetailById(@PathVariable String orderId) {
		logger.info("request : " + orderId);
		Order order = orderSummary.read(orderId);
		if (order != null) {
			logger.info("response : " + order.toString());
			return new ResponseEntity<>(order, HttpStatus.OK);
		} else
			throw new OrderNotfoundException();
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrderDetail() {

		List<Order> order = orderSummary.getAllData();
		if (order != null)
			return new ResponseEntity<>(order, HttpStatus.OK);
		else
			throw new OrderNotfoundException();
	}

	@PostMapping(value = "/orders/{orderId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> insertOrderDetailById(@RequestBody Order order, @PathVariable String orderId) {

		String response = orderSummary.insertOrder(orderId, order);
		if (response == "Success")
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			throw new OrderNotfoundException(response);
	}

	@PostMapping(value = "/acceptorder/{orderId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> acceptOrder(@RequestBody Order order, @PathVariable String orderId) {

		String response = orderSummary.acceptOrder(orderId, order);
		if (response == "Success")
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			throw new OrderNotfoundException(response);
	}

	@DeleteMapping(value = "/orders/{orderId}")
	public ResponseEntity<String> deleteOrderDetailById(@PathVariable String orderId) {

		boolean isRemoved = orderSummary.deleteOrder(orderId);
		if (!isRemoved) {
			throw new OrderNotfoundException();
		}
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}
}
