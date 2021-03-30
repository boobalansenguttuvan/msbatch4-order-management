package com.sl.ms.ordermanagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ITEMS")
public class Item {

	public Item(int id, Order order, String name, int quantity, double price, double amount) {
		this.id = id;
		this.order = order;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}

	public Item() {

	}

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	private String name;
	private int quantity;
	private double price;

	@Transient
	private double amount;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", amount="
				+ amount + "]";
	}

}
