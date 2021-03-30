package com.sl.ms.ordermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sl.ms.ordermanagement.dto.Order;


public interface IOrdersDao extends JpaRepository<Order, Integer> {


}
