package com.sl.ms.ordermanagement.exception;

public class OrderNotfoundException extends RuntimeException {
	public OrderNotfoundException() {
		// TODO Auto-generated constructor stub
	}

	public OrderNotfoundException(String response) {
		super(response);
	}

	private static final long serialVersionUID = 1L;

}
