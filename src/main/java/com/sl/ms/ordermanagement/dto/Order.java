package com.sl.ms.ordermanagement.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	public Order(int id, String name, double total_amount, Set<Item> items) {
		
		this.id = id;
		this.name = name;
		this.total_amount = total_amount;
		this.items = items;
	}
	
	public Order() {
		
	}

	@Id
	private int id;

	private String name;

	@Transient
	private double total_amount;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<Item> items;

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;	
		for (Item item : this.items) {
			item.setOrder(this);
		}
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

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", total_amount=" + total_amount + ", items=" + items + "]";
	}

}
