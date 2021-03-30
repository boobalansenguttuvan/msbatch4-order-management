package com.sl.ms.ordermanagement.dao;

import java.util.List;

import com.sl.ms.ordermanagement.dto.Item;
import com.sl.ms.ordermanagement.dto.Order;



public interface IOrderDataServiceDao {
	
	List<Order> read(int id);

	void update(Order order);

	void delete(int id);

	List<Order> getAllData();

	void truncateData();
	
	void add(Order order, List<Item> items);
	
	void loadBackupData(List<Order> o);

}
