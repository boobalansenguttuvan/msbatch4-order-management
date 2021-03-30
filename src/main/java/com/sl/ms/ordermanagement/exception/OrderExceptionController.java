package com.sl.ms.ordermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {

	@ExceptionHandler(value = OrderNotfoundException.class)
	public ResponseEntity<Object> exception(OrderNotfoundException exception) {
		if (exception.getMessage()== null || exception.getMessage().isEmpty())
			return new ResponseEntity<>("Order or Item not found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
