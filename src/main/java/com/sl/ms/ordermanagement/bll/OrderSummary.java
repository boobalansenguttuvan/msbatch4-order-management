package com.sl.ms.ordermanagement.bll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.ms.ordermanagement.communicator.RestCommunicator;
import com.sl.ms.ordermanagement.dao.IOrdersDao;
import com.sl.ms.ordermanagement.dto.Item;
import com.sl.ms.ordermanagement.dto.Order;
import com.sl.ms.ordermanagement.model.Products;

@Component
public class OrderSummary implements IOrderSummaryReport {

	@Autowired
	private IOrdersDao ordersRepo;

	@Override
	public List<Order> getAllData() {

		List<Order> orders = ordersRepo.findAll();

		for (Order order : orders) {
			order.setTotal_amount(0);
			for (Item item : order.getItems()) {
				item.setAmount(item.getPrice() * item.getQuantity());
				item.setOrder(null);
				order.setTotal_amount(order.getTotal_amount() + item.getAmount());
			}
		}
		return orders;
	}

	@Override
	public Order read(String orderId) {

		Order order = ordersRepo.findById(Integer.parseInt(orderId)).orElse(null);
		if (order != null) {
			order.setTotal_amount(0);
			for (Item item : order.getItems()) {
				item.setAmount(item.getPrice() * item.getQuantity());
				item.setOrder(null);
				order.setTotal_amount(order.getTotal_amount() + item.getAmount());
			}
		}
		return order;
	}

	@Override
	public String acceptOrder(String orderId, Order order) {
		try {

			Set<Item> newItems = order.getItems();

			RestCommunicator rc = new RestCommunicator();
			Products[] availableProduct = rc.getAvailableProducts();
			List<Products> exstingItems = new ArrayList<>(Arrays.asList(availableProduct));

			List<Products> filteredList = exstingItems.stream()
					.filter(existItem -> newItems.stream().anyMatch(newItem -> existItem.getId() == newItem.getId()))
					.collect(Collectors.toList());

			if (filteredList.size() == newItems.size()) {
				order = ordersRepo.save(order);
				return "Success";
			} else
				return "Item is not available for order";

		} catch (Exception ex) {
			return "Failure" + ex.getMessage();
		}
	}

	@Override
	public boolean deleteOrder(String orderId) {
		try {
			Order order = read(orderId);
			if (order != null) {
				ordersRepo.deleteById(Integer.parseInt(orderId));
				return true;
			} else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public String insertOrder(String orderId, Order order) {
		try {

			Set<Item> newItems = order.getItems();

			List<Item> exstingItems = ordersRepo.findAll().stream().flatMap(or -> or.getItems().stream())
					.filter(item -> item.getClass().toString().contains("Item")).collect(Collectors.toList());

			List<Item> filteredList = exstingItems.stream()
					.filter(existItem -> newItems.stream().anyMatch(newItem -> existItem.getId() == newItem.getId()))
					.collect(Collectors.toList());
			if (filteredList.size() == newItems.size()) {
				order = ordersRepo.save(order);
				return "Success";
			} else
				return "Item is not available for order";
		} catch (Exception ex) {
			return "Failure" + ex.getMessage();
		}
	}
}
